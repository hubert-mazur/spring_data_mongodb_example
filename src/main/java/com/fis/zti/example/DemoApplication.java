package com.fis.zti.example;

import com.fis.zti.example.examples.Example1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


        Example1 example1 = new Example1();

    }

}
