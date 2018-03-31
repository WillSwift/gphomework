package pattern.strategy.will;

public class FeiZhuSite implements TrainTicketInterface {
    public TrainTicketInfo getTrainTicketInfo(String dptrSite, String arrvSite) {
        System.out.println("欢迎访问飞猪旅行网");
        return new TrainTicketInfo(dptrSite, arrvSite, 200);
    }
}
