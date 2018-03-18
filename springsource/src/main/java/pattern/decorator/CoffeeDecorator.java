package pattern.decorator;

public class CoffeeDecorator implements CoffeeMachine {

    private CoffeeMachine instance;

    public CoffeeDecorator(CoffeeMachine coffeeMachine) {
        this.instance = coffeeMachine;
    }

    public void makeCoffee() {
        System.out.println("在咖啡最上层制作心形奶花");
        instance.makeCoffee();
    }
}
