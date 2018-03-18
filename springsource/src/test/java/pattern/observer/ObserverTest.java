package pattern.observer;

import org.junit.Test;
import pattern.observer.will.core.Event;
import pattern.observer.will.subject.DNFFusillade;
import pattern.observer.will.subject.Keyboard;
import pattern.observer.will.subject.KeyboardEventType;

import java.lang.reflect.Method;

public class ObserverTest {

    @Test
    public void testFusillade() {
        try {
            Keyboard keyboard = new Keyboard();
            DNFFusillade dnfFusillade = new DNFFusillade();
            Method callback = DNFFusillade.class.getMethod("advice", new Class<?>[] {Event.class});

            keyboard.addListener(KeyboardEventType.PRESS_X, dnfFusillade, callback);
            keyboard.addListener(KeyboardEventType.PRESS_Y, dnfFusillade, callback);

            keyboard.pressX();
            keyboard.pressY();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
