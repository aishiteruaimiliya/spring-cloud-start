package main.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@EnableEurekaClient
public class ConfigClientAppclication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientAppclication.class,args);
    }

    @Value("${hello}")
    String content;
    @Value("${server.port")
    @RequestMapping("/")
    public String home() {
        return "hello:" + content;
    }
}
