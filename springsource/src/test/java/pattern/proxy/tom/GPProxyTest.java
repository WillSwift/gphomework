package pattern.proxy.tom;

import org.junit.Test;
import pattern.proxy.model.Person;
import pattern.proxy.model.Will;

public class GPProxyTest {

    @Test
    public void testGPExpress() {
        Person person = (Person)new GPExpress().getInstance(new Will());
        person.expressDelivery();
    }
}
