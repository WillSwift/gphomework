package pattern.observer.tom.subject;

import pattern.observer.tom.core.EventListener;

public class Subject extends EventListener {

    public void add() {
        System.out.println("调用了添加方法");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove() {
        System.out.println("调用了删除方法");
        trigger(SubjectEventType.ON_REMOVE);
    }
}
