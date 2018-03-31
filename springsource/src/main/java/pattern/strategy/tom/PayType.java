package pattern.strategy.tom;

public enum PayType {
    ALI_PAY(new AliPay()), WECHAT_PAY(new WeChatPay());

    private Payment payment;

    private PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return payment;
    }
}
