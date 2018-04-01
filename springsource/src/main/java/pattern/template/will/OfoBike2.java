package pattern.template.will;

public class OfoBike2 extends Ofo {
    @Override
    protected String scan() {
        String password = "9527";
        System.out.println("扫码成功，获取密码：" + password);
        return password;
    }
}
