package pattern.proxy.jdk;

import org.junit.Test;
import pattern.proxy.model.Person;
import pattern.proxy.model.Will;

public class JdkProxyTest {

    @Test
    public void testSFExpress() {
        Person person = (Person)new SFExpress().getInstance(new Will());
        person.expressDelivery();
    }
}
