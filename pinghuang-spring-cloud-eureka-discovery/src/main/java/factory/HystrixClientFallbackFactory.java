package factory;

import feign.hystrix.FallbackFactory;
import main.java.service.Consumer;

public class HystrixClientFallbackFactory implements FallbackFactory<main.java.service.Consumer> {
    // 服务故障之时调用的方法
    @Override
    public Consumer create(Throwable throwable) {
        return (a,b)->a-b;
    }
}
