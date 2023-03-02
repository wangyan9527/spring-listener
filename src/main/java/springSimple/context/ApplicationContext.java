package springSimple.context;

import springSimple.event.Event;
import springSimple.listener.Listener;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 上下文类
 *
 * @author wy
 */
public class ApplicationContext {

    private final Set<Listener<?>> listeners = new LinkedHashSet<>();

    /**
     * 注册bean（监听器）
     *
     * @param listener
     */
    public void registerListener(Listener<?> listener) {
        listeners.add(listener);
    }

    /**
     * 发布事件
     *
     * @param event
     */
    public void publish(Event event) {
        Set<Listener<?>> matchedListeners = getMatchedListeners(event);
        matchedListeners.forEach(listener -> this.invokeListener(listener, event));
    }

    // ------------- private methods -------------
    private Set<Listener<?>> getMatchedListeners(Event event) {
        if (listeners.isEmpty()) {
            return Collections.emptySet();
        }

        return listeners.stream()
                .filter(listener -> listener.supportsEventType(event))
                .collect(Collectors.toSet());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void invokeListener(Listener listener, Event event) {
        listener.onApplicationEvent(event);
    }

}
