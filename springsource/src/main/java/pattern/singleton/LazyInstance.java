package pattern.singleton;

import java.io.Serializable;

/**
 * 懒汉式
 */
public class LazyInstance implements Serializable {

    private volatile static LazyInstance INSTANCE = null;

    private LazyInstance() {

    }

    public static LazyInstance getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyInstance.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyInstance();
                }
            }
        }
        return INSTANCE;
    }
}
