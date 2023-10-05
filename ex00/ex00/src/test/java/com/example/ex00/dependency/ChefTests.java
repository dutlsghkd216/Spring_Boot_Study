package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ChefTests {
    @Autowired
    Restaurant restaurant;

    @Test
    public void chefTest(){
        log.info(restaurant.getChef().toString());
    }

}
