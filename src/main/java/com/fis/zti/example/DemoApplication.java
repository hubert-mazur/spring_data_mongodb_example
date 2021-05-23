package com.fis.zti.example;

import com.fis.zti.example.examples.example1.Example1;
import com.fis.zti.example.examples.example2.Example2;
import com.fis.zti.example.examples.example3.Example3;
import com.fis.zti.example.examples.example4.Example4;
import com.fis.zti.example.examples.example5.Example5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);


        Example1 example1 = new Example1();
//        Example2 example2 = new Example2();
//        Example3 example3 = new Example3();
//        Example4 example4 = new Example4();
//        Example5 example5 = new Example5(applicationContext);

    }

}
