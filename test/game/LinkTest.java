package game;


import model.Link;
import model.SandTile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LinkTest {

    private Link link;

    @Before
    public void setUp() throws Exception {
        link = new Link();
    }

    @Test
    public void Link_InstanceOfElement_True() {


        assertTrue(link instanceof Element);
    }

    @Test
    public void handleCollisionWithDeltaYOf10_y_doubleValueOf0() {
        SandTile sandTile = new SandTile();

        link.setDeltaY(10);
        double expectedYAfterCollision = link.getY()- link.getDeltaY();

        link.handleCollision(sandTile);

        assertTrue(link.getY() == expectedYAfterCollision);
    }
}

