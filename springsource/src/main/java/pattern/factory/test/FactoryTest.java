package pattern.factory.test;

import pattern.factory.abst.AbstractFactory;
import pattern.factory.abst.MSIFactory;
import pattern.factory.function.DellFactory;
import pattern.factory.function.FuncFactory;
import pattern.factory.model.Computer;
import pattern.factory.model.Mouse;
import pattern.factory.simple.SimpleFactory;

public class FactoryTest {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Computer computer = simpleFactory.produce("MSI");
        System.out.println(computer.getName());
        System.out.println("--------");

        FuncFactory funcFactory = new DellFactory();
        computer = funcFactory.produce();
        System.out.println(computer.getName());
        System.out.println("--------");

        AbstractFactory abstractFactory = new MSIFactory();
        computer = abstractFactory.produceComputer();
        Mouse mouse = abstractFactory.produceMouse();
        System.out.println(computer.getName());
        System.out.println(mouse.getName());
    }
}
