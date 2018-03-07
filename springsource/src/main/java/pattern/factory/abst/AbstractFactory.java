package pattern.factory.abst;

import pattern.factory.model.Computer;
import pattern.factory.model.Mouse;

public interface AbstractFactory {

    Computer produceComputer();

    Mouse produceMouse();
}
