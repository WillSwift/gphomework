package pattern.observer.tom.subject;

import pattern.observer.tom.core.Event;

import java.lang.reflect.Method;

public class ObserverTest {

    public static void main(String[] args) {
        try {
            Subject subject = new Subject();
            Observer observer = new Observer();
            Method callback = Observer.class.getMethod("advice", new Class<?>[] {Event.class});

            subject.addListener(SubjectEventType.ON_ADD, observer, callback);
            subject.addListener(SubjectEventType.ON_REMOVE, observer, callback);
            subject.add();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
