package pattern.template.will;

import org.junit.Test;

public class TemplateTest {

    @Test
    public void testOfo() {
        OfoBike1 bike1 = new OfoBike1();
        bike1.rideBike();

        System.out.println("--------");
        
        OfoBike2 bike2 = new OfoBike2();
        bike2.rideBike();
    }
}
