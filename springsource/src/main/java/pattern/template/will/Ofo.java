package pattern.template.will;

public abstract class Ofo {

    public void rideBike() {
        // 1.扫码
        String password = scan();
        // 2.输入密码
        inputPassword(password);
        // 3.解锁
        open();
        // 4.骑行
        ride();
    }

    protected abstract String scan();

    private void inputPassword(String password) {
        System.out.println("输入密码：" + password);
    }

    private void open() {
        System.out.println("解锁");
    }

    private void ride() {
        System.out.println("骑行");
    }
}
