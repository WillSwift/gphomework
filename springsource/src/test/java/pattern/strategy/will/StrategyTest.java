package pattern.strategy.will;

import org.junit.Test;

public class StrategyTest {

    @Test
    public void testTicket() {
        Person person = new Person("上海", "杭州");
        TrainTicketInfo trainTicketInfo = person.searchTicket(SearchType.TIEYOU);
        System.out.println(trainTicketInfo.toString());
    }
}
