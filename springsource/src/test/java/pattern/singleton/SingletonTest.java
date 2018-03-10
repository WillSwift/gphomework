package pattern.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class SingletonTest {
    int threadNum = 1000;
    CountDownLatch startGate;
    CountDownLatch endGate;
    Map<Object, Object> map;
    AtomicInteger count;

    @Before
    public void beforeTest() {
        startGate = new CountDownLatch(1);
        endGate = new CountDownLatch(threadNum);
        map = new ConcurrentHashMap<Object, Object>();
        count = new AtomicInteger(0);
    }

    @After
    public void afterTest() throws Exception {
        long startTime = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long endTime = System.currentTimeMillis();
        System.out.println("Spend :" + (endTime - startTime));
        if (count.get() != 1) {
            System.out.println("非单例");
        } else {
            System.out.println("单例");
        }
    }

    @Test
    public void testHungry() throws Exception {

        for (int i = 0; i < threadNum; i++) {
            new Thread() {
              public void run() {
                  try {
                      startGate.await();
                      HungryInstance hungryInstance = HungryInstance.getInstance();
                      System.out.println(System.currentTimeMillis() + ":" + hungryInstance);
                      if (!map.containsKey(hungryInstance)) {
                          map.put(hungryInstance, hungryInstance);
                          count.getAndIncrement();
                      }
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } finally {
                      endGate.countDown();
                  }
              }
            }.start();
        }

    }

    @Test
    public void testLazy() throws Exception {

        for (int i = 0; i < threadNum; i++) {
            new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        LazyInstance lazyInstance = LazyInstance.getInstance();
                        System.out.println(System.currentTimeMillis() + ":" + lazyInstance);
                        if (!map.containsKey(lazyInstance)) {
                            map.put(lazyInstance, lazyInstance);
                            count.getAndIncrement();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        endGate.countDown();
                    }
                }
            }.start();
        }

    }

    @Test
    public void testStaticInnerClazz() throws Exception {

        for (int i = 0; i < threadNum; i++) {
            new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        StaticClazzInstance instance = StaticClazzInstance.getInstance();
                        System.out.println(System.currentTimeMillis() + ":" + instance);
                        if (!map.containsKey(instance)) {
                            map.put(instance, instance);
                            count.getAndIncrement();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        endGate.countDown();
                    }
                }
            }.start();
        }

    }

    @Test
    public void testRegister() throws Exception {

        for (int i = 0; i < threadNum; i++) {
            new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        RegisterInstance instance = RegisterInstance.getInstance(null);
                        System.out.println(System.currentTimeMillis() + ":" + instance);
                        if (!map.containsKey(instance)) {
                            map.put(instance, instance);
                            count.getAndIncrement();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        endGate.countDown();
                    }
                }
            }.start();
        }

    }

    /**
     * 测试序列化
     */
    public static void main(String[] args) {
        try {
            StaticClazzInstance staticClazzInstance = StaticClazzInstance.getInstance();

            FileOutputStream fileOutputStream = new FileOutputStream("Serializable.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(staticClazzInstance);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("Serializable.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            StaticClazzInstance staticClazzInstance1 = (StaticClazzInstance)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(" static :" + (staticClazzInstance == staticClazzInstance1));

            LazyInstance lazyInstance = LazyInstance.getInstance();

            fileOutputStream = new FileOutputStream("Serializable.obj1");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lazyInstance);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();

            fileInputStream = new FileInputStream("Serializable.obj1");
            objectInputStream = new ObjectInputStream(fileInputStream);
            LazyInstance lazyInstance1 = (LazyInstance)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(" lazy :" + (lazyInstance == lazyInstance1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
