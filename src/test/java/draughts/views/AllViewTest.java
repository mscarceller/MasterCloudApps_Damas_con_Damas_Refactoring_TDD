package draughts.views;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    BoardViewTest.class, 
    PlayViewTest.class, 
    CancelViewTest.class,
    ResumeViewTest.class } )
public final class AllViewTest {
}