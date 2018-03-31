package pattern.strategy.will;

/**
 * 火车票查询方式
 */
public enum SearchType {
    TIEYOU(new TieYouApp()), FEIZHU(new FeiZhuSite());

    private TrainTicketInterface trainTicketInterface;

    private SearchType(TrainTicketInterface trainTicketInterface) {
        this.trainTicketInterface = trainTicketInterface;
    }

    public TrainTicketInterface getTrainTicketInterface() {
        return trainTicketInterface;
    }
}
