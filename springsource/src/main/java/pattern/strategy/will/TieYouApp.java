package pattern.strategy.will;

public class TieYouApp implements TrainTicketInterface {
    public TrainTicketInfo getTrainTicketInfo(String dptrSite, String arrvSite) {
        System.out.println("欢迎使用铁友APP");
        return new TrainTicketInfo(dptrSite, arrvSite, 200);
    }
}
