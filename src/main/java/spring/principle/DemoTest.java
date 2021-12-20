package spring.principle;

import org.junit.Before;
import org.junit.Test;

import spring.principle.OrderService;
import spring.principle.context.ApplicationContext;
import spring.principle.listener.CarApplicationListener;
import spring.principle.listener.SmsApplicationListener;

/**
 * 测试类，principle目录下的文件是按照spring监听器源码进行模拟的
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
public class DemoTest {

    // 之所以设计成public static，是为了能在OrderService中拿到SmsService，毕竟我没实现Autowired自动注入
    public static ApplicationContext applicationContext;
    public static OrderService orderService;
    public static SmsApplicationListener smsApplicationListener;
    public static CarApplicationListener carApplicationListener;

    @Before
    public void initApplicationContext() {
        applicationContext = new ApplicationContext();
        orderService = (OrderService) applicationContext.getBean("spring.principle.OrderService");
        smsApplicationListener =  (SmsApplicationListener) applicationContext.getBean("spring.principle.listener.SmsApplicationListener");
        carApplicationListener = (CarApplicationListener) applicationContext.getBean("spring.principle.listener.CarApplicationListener");
    }

    @Test
    public void testSpringEvent() {
        // 用户下单（试着点进去，把orderService发布的事件改为OtherEvent）
        orderService.order();
    }

}
