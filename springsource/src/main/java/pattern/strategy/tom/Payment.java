package pattern.strategy.tom;

public interface Payment {

    PayState pay(String uid, double amount);
}
