package pattern.strategy.will;

/**
 * 火车票查询接口
 */
public interface TrainTicketInterface {

    TrainTicketInfo getTrainTicketInfo(String dptrSite, String arrvSite);
}
