package draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import draughts.controllers.AllControllerTest;
import draughts.models.AllModelTest;
import draughts.views.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllModelTest.class, 
    AllControllerTest.class, 
    AllViewTest.class } )
public final class AllTest {
}