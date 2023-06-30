package org.springframework.test.service;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 11:38
 */
public class WorldServiceImpl implements WorldService{
    @Override
    public void explode() {
        System.out.println("The Earth is going to explode");
    }
}
