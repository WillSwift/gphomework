package pattern.prototype;

import org.junit.Test;

import java.util.Date;

public class PrototypeTest {

    @Test
    public void testDeepClone() throws Exception {
        Position position1 = new Position(0, 1);
        Chess whiteChess1 = new Chess(ChessColor.WHITE, new Date(), position1);
        Position position2 = new Position(1, 1);
        Chess blackChess1 = new Chess(ChessColor.BLACK, new Date(), position2);

        Chess whiteChess2 = (Chess)whiteChess1.clone();
        whiteChess2.getPosition().setX(3);
        System.out.println(whiteChess1 == whiteChess2);
        System.out.println(whiteChess1.getPosition() == whiteChess2.getPosition());

        System.out.println(whiteChess1);
        System.out.println(blackChess1);
        System.out.println(whiteChess2);

    }
}
