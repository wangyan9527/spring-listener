package spring.principle.listener;

import org.springframework.stereotype.Component;

import spring.principle.event.OrderSuccessEvent;

/**
 * 短信服务类，监听用户下单事件。只要下单成功，就会监听到
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
@Component
public class SmsApplicationListener implements ApplicationListener<OrderSuccessEvent> {

    @Override
    public void onApplicationEvent(OrderSuccessEvent event) {
        sendSms();
    }

    public void sendSms() {
        try {
            Thread.sleep(1000L * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送短信成功...");
    }

}
