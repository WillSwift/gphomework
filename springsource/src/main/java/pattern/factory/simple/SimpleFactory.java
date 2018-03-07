package pattern.factory.simple;

import pattern.factory.model.Computer;
import pattern.factory.model.Dell;
import pattern.factory.model.MSI;

public class SimpleFactory {

    public Computer produce(String name) {
        if ("Dell".equals(name)) {
            return new Dell();
        } else if ("MSI".equals(name)) {
            return new MSI();
        } else {
            return null;
        }
    }
}
