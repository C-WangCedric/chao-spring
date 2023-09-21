package org.springframework.test.aop;

import com.deepoove.poi.XWPFTemplate;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.AdvisedSupport;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.TargetSource;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.CglibAopProxy;
import org.springframework.aop.framework.JdkDynamicAopProxy;
import org.springframework.test.common.WorldServiceInterceptor;
import org.springframework.test.service.WorldService;
import org.springframework.test.service.WorldServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 11:31
 */
public class DynamicProxyTest {
    private AdvisedSupport support = new AdvisedSupport();

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();
        TargetSource targetSource = new TargetSource(worldService);
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.WorldService.explode(..))").getMethodMatcher();

        support.setMethodMatcher(methodMatcher);
        support.setMethodInterceptor(new WorldServiceInterceptor());
        support.setTargetSource(targetSource);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService world = (WorldService) new JdkDynamicAopProxy(support).getProxy();
        /**
         * Do something before the earth explodes
         * The Earth is going to explode
         * Do something after the earth explodes
         */
        world.explode();
    }

    @Test
    public void testCglibAopProxy() {
        WorldService world = (WorldService) new CglibAopProxy(support).getProxy();
        world.explode();
    }

    @Test
    public void downloadExcel() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat", "root", "111");
            String sql = "SELECT * FROM final";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // 创建Word文档
            XWPFDocument document = new XWPFDocument();
            int i = 0;
            String curMarks[] = {"8", "8", "8", "4", "4"};
            String totalMarks[] = {"8", "16", "24", "28", "32"};
            String nums[] = {"一", "二", "三", "四", "五"};
            // 遍历结果集并将数据填充到Word文档中
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String projectName = resultSet.getString("project_name");
                String time = resultSet.getString("time");
                String timeRange = resultSet.getString("time_range");
                // 获取文件流
                InputStream stream = DynamicProxyTest.class.getClassLoader().getResourceAsStream("downloadWord.docx");
                // 填充数据
                Map<String, String> data = new HashMap<>();
                data.put("name", name);
                data.put("projectName", projectName);
                data.put("time", time);
                data.put("timeRange", timeRange);
                data.put("curMark", curMarks[i]);
                data.put("totalMark", totalMarks[i]);
                XWPFTemplate template = XWPFTemplate.compile(stream).render(data);
                FileOutputStream outputStream = new FileOutputStream(data.get("name") + "-第" + nums[i] + "次跟踪情况记录.docx");
                template.write(outputStream);
                outputStream.close();
                i = (i + 1) % 5;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
