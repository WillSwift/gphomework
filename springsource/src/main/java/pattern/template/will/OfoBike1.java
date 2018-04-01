package pattern.template.will;

public class OfoBike1 extends Ofo {
    @Override
    protected String scan() {
        String password = "1101";
        System.out.println("扫码成功，获取密码：" + password);
        return password;
    }
}
