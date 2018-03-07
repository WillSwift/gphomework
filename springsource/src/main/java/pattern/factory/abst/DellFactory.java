package pattern.factory.abst;

import pattern.factory.model.Computer;
import pattern.factory.model.Dell;
import pattern.factory.model.Mouse;
import pattern.factory.model.MuMaRen;

public class DellFactory implements AbstractFactory {
    public Computer produceComputer() {
        return new Dell();
    }

    public Mouse produceMouse() {
        return new MuMaRen();
    }
}
