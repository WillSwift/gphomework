package pattern.strategy.will;

public class Person {

    private String dptrSite;
    private String arrvSite;

    public Person(String dptrSite, String arrvSite) {
        this.dptrSite = dptrSite;
        this.arrvSite = arrvSite;
    }

    public TrainTicketInfo searchTicket(SearchType searchType) {
        return searchType.getTrainTicketInterface().getTrainTicketInfo(dptrSite, arrvSite);
    }
}
