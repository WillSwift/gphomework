package pattern.observer.will.subject;

import pattern.observer.will.core.Event;

public class DNFFusillade {

    public void advice(Event e) {
        if (KeyboardEventType.PRESS_X == e.getTrigger()) {
            System.out.println("DNF连发，一次X键触发多次普通攻击");
        }
    }
}
