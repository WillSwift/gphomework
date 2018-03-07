package pattern.factory.abst;

import pattern.factory.model.Computer;
import pattern.factory.model.DaErYou;
import pattern.factory.model.MSI;
import pattern.factory.model.Mouse;

public class MSIFactory implements AbstractFactory {

    public Computer produceComputer() {
        return new MSI();
    }

    public Mouse produceMouse() {
        return new DaErYou();
    }
}
