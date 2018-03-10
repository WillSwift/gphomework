package pattern.singleton;

import java.io.Serializable;

/**
 * 静态内部类式
 */
public class StaticClazzInstance implements Serializable {

    private StaticClazzInstance() {

    }

    private static class InnerClazz {
        private static StaticClazzInstance INSTANCE = new StaticClazzInstance();
    }

    public static StaticClazzInstance getInstance() {
        return InnerClazz.INSTANCE;
    }

    private Object readResolve() {
        return InnerClazz.INSTANCE;
    }
}
