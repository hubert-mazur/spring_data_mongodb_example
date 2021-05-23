package com.fis.zti.example.rest;

import com.fis.zti.example.examples.example1.Example1;
import com.fis.zti.example.examples.example2.Example2;
import com.fis.zti.example.examples.example3.Example3;
import com.fis.zti.example.examples.example4.Example4;
import com.fis.zti.example.examples.example5.Example5;
import com.fis.zti.example.examples.example5.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/zti")
@Service
public class ExampleController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "example1")
    public void example1() {
        Example1 example1 = new Example1();
    }

    @GetMapping(path = "example2")
    public void example2() {
        Example2 example2 = new Example2();
    }

    @GetMapping(path = "example3")
    public void example3() {
        Example3 example3 = new Example3();
    }

    @GetMapping(path = "example4")
    public void example4() {
        Example4 example4 = new Example4();
    }

    @GetMapping(path = "example5")
    public void example5() {
        Example5 example5 = new Example5(personService);
    }

}
