package draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    BoardTest.class,
    CoordinateTest.class, 
    PieceTest.class,
    GameWithDraughtsTest.class,
    GameWithMultipleJumps.class,
    GameTest.class, } )
public final class AllModelTest {
}
