package pattern.strategy.tom;

public class WeChatPay implements Payment {
    public PayState pay(String uid, double amount) {
        String msg = "【微信支付】付款账号：" + uid + "，付款金额：" + amount;
        return new PayState(200, msg, null);
    }
}
