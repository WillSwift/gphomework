package pattern.observer.will.core;

import java.lang.reflect.Method;

public class Event {

    // 事件源
    private Object subject;
    // 通知目标
    private Object target;
    // 回调方法
    private Method callback;
    // 触发器
    private Enum trigger;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSubject() {
        return subject;
    }

    void setSubject(Object subject) {
        this.subject = subject;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public Enum getTrigger() {
        return trigger;
    }

    Event setTrigger(Enum trigger) {
        this.trigger = trigger;
        return this;
    }
}
