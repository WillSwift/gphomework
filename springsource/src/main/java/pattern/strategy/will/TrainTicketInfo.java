package pattern.strategy.will;

public class TrainTicketInfo {

    private String dptrSite;
    private String arrvSite;
    private double price;

    public TrainTicketInfo(String dptrSite, String arrvSite, double price) {
        this.dptrSite = dptrSite;
        this.arrvSite = arrvSite;
        this.price = price;
    }

    @Override
    public String toString() {
        return "始发地：" + dptrSite + ",到达地：" + arrvSite + ",票价：" + price;
    }
}
