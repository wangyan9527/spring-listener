package jdk.publisher;

import java.util.ArrayList;
import java.util.List;

import jdk.event.TaskFinishEvent;
import jdk.listener.TaskFinishEventListener;

/**
 * 事件发布器
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
public class TaskFinishEventPublisher {

    private List<TaskFinishEventListener> listenerList = new ArrayList<>();

    /**
     * 注册监听器
     */
    public synchronized void register(TaskFinishEventListener listener) {
        if (!listenerList.contains(listener)) {
            listenerList.add(listener);
        }
    }

    /**
     * 移除监听器
     */
    public synchronized boolean remove(TaskFinishEventListener listener) {
        return listenerList.remove(listener);
    }

    /**
     * 发布任务完成事件
     */
    public void publishEvent(TaskFinishEvent event) {
        for (TaskFinishEventListener taskFinishEventListener : listenerList) {
            taskFinishEventListener.onTaskFinish(event);
        }
    }

}
