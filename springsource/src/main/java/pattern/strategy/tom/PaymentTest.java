package pattern.strategy.tom;

public class PaymentTest {

    public static void main(String[] args) {
        Order order = new Order("9527", "K7878484", 200);
        PayState payState = order.pay(PayType.ALI_PAY);
        System.out.println(payState.toString());
    }
}
