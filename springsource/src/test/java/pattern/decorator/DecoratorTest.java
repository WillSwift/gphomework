package pattern.decorator;

import org.junit.Test;

public class DecoratorTest {

    @Test
    public void testDecorator() {
        CoffeeDecorator coffeeDecorator = new CoffeeDecorator(new Cappuccino());
        coffeeDecorator.makeCoffee();
    }
}
