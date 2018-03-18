package pattern.observer.will.subject;

import pattern.observer.will.core.EventListener;

public class Keyboard extends EventListener {

    public void pressX() {
        System.out.println("按下X键");
        trigger(KeyboardEventType.PRESS_X);
    }

    public void pressY() {
        System.out.println("按下Y键");
        trigger(KeyboardEventType.PRESS_Y);
    }
}
