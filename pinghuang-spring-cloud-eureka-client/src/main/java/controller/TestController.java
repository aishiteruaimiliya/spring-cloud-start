package main.java.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a,@RequestParam Integer b){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("compute-service",false);
        return a+b;
    }


}
