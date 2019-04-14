package game;

import model.WaterTile;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WaterTileTest {

    @Test
    public void WaterTile_InstanceOfTile_True() {
        WaterTile waterTile = new WaterTile();

        assertTrue(waterTile instanceof Tile);
    }
}
