package pattern.factory.function;

import pattern.factory.model.Computer;
import pattern.factory.model.MSI;

public class MSIFactory implements FuncFactory {

    public Computer produce() {
        return new MSI();
    }
}
