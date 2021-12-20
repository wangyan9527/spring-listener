package spring.principle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import spring.principle.publisher.ApplicationEventMulticaster;
import spring.principle.publisher.SimpleApplicationEventMulticaster;

/**
 * 配置类
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
@Configuration
public class Config {

    // 在SimpleApplicationEventMulticaster中设置线程池，开启监听者异步通知
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster
                = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }

}
