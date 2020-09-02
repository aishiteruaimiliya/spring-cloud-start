package controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    // 该注解可以都依赖服务进行隔离，降级，快速失败，快速重试等等

    // fallbackMethod 降级方法
    // commandProperties 可以配置hystrixCommand对应属性，例如采用线程池还是信号量隔离，熔断规则等等
    // ignoreException 忽略的异常
    // groupKey
    // commandKey 命令名称
    @HystrixCommand(fallbackMethod = "defaultStores")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Integer testeureka(@RequestParam("a") Integer a,@RequestParam("b") Integer b){
        return consumer.index(a,b);
    }
//    @RequestMapping(value = "/add",method = RequestMethod.GET)
//    public Integer testAdd(@RequestParam Integer a,@RequestParam Integer b){
//        return consumer.add(a,b);
//    }
    // 降级方法
    public Integer defaultStores(){
        return 0;
    }
}
