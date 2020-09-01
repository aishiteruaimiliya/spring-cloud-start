package main.java.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "compute-service",fallback = CosumerFallBack.class)
public interface Consumer {
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    Integer index(@RequestParam("a") Integer a,@RequestParam("b") Integer b);

//    @RequestMapping(value = "/add")
//    Integer add(@RequestParam final Integer a, @RequestParam final Integer b);
}
