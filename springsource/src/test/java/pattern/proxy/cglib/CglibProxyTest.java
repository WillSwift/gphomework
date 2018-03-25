package pattern.proxy.cglib;

import org.junit.Test;
import pattern.proxy.model.Will;

public class CglibProxyTest {

    @Test
    public void testYDExpress() {
        Will will = (Will)new YDExpress().getInstance(Will.class);
        will.expressDelivery();
    }
}
