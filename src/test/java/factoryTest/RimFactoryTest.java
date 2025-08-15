package factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Rim;
import za.co.tt.factory.RimFactory;

public class RimFactoryTest {
    @Test
    public void createRimTest() {
        Rim rim = RimFactory.createRim("18", "Alloy", "Black");
        System.out.println(rim.toString());
        assert rim != null;
    }

    @Test
    public void createRimWithInvalidSizeTest() {
        Rim rim = RimFactory.createRim("invalid", "Alloy", "Black");
        System.out.println(rim.toString());
        assert rim == null; // Assuming the factory returns null for invalid size
    }

}