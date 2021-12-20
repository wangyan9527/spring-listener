package jdk.listener;

import jdk.event.TaskFinishEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 邮件服务监听器
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
@Data
@AllArgsConstructor
public class MailTaskFinishListener implements TaskFinishEventListener {

    private String email;

    @Override
    public void onTaskFinish(TaskFinishEvent event) {
        System.out.println("send Email to " + email + " Task:" + event.getSource());
    }
}
