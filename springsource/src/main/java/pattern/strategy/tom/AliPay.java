package pattern.strategy.tom;

public class AliPay implements Payment {
    public PayState pay(String uid, double amount) {
        String msg = "【支付宝支付】支付账号：" + uid + "，付款金额：" + amount;
        return new PayState(200, msg, null);
    }
}
