package com.wang;

import com.wang.pojo.Dog;
import com.wang.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemo01ApplicationTests {

    @Autowired
        private Person person;
//    private Dog person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
