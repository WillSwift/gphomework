package pattern.observer.tom.subject;

import pattern.observer.tom.core.Event;

public class Observer {

    public void advice(Event e) {
        System.out.println("触发事件：" + e);
    }
}
