package pattern.observer.will.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventListener {

    private Map<Enum, Event> eventMap = new HashMap<Enum, Event>();

    public void addListener(Enum eventType, Object target, Method method) {
        eventMap.put(eventType, new Event(target, method));
    }

    private void trigger(Event e) {
        e.setSubject(this);

        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }

    protected void trigger(Enum eventType) {
        if (!eventMap.containsKey(eventType)) {
            return;
        }
        trigger(eventMap.get(eventType).setTrigger(eventType));
    }
}
