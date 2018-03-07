package pattern.factory.function;

import pattern.factory.model.Computer;
import pattern.factory.model.Dell;

public class DellFactory implements FuncFactory {

    public Computer produce() {
        return new Dell();
    }
}
