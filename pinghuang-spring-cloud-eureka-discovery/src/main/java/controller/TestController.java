package main.java.controller;

import main.java.service.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    Consumer consumer;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Integer testeureka(@RequestParam("a") Integer a,@RequestParam("b") Integer b){
        return consumer.index(a,b);
    }
//    @RequestMapping(value = "/add",method = RequestMethod.GET)
//    public Integer testAdd(@RequestParam Integer a,@RequestParam Integer b){
//        return consumer.add(a,b);
//    }
}
