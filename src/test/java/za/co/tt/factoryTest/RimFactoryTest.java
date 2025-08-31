package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Rim;
import za.co.tt.factory.RimFactory;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RimFactoryTest {

    @Test
    void createRim_shouldReturnValidRim() {
        Rim rim = RimFactory.createRim(
                "OZ Racing", "OZR123", 19.0f, "5x112", 5, 112.0f, BigDecimal.valueOf(3200.00), 10, "http://example.com/rim.jpg"
        );
        assertNotNull(rim);
        assertEquals("OZ Racing", rim.getBrandName());
    }

    @Test
    void createRim_withNullManufactureCode_shouldReturnRimWithNullCode() {
        Rim rim = RimFactory.createRim(
                "BBS", null, 18.0f, "5x120", 5, 120.0f, BigDecimal.valueOf(3500.00), 8, "http://example.com/rim2.jpg"
        );
        assertNull(rim.getManufactureCode());
    }

    @Test
    void updateRim_shouldSetIdAndUpdateFields() {
        Rim rim = RimFactory.updateRim(
                2L, "Enkei", "ENK456", 17.0f, "4x100", 4, 100.0f, BigDecimal.valueOf(2800.00), 15, "http://example.com/rim3.jpg"
        );
        assertEquals(2L, rim.getId());
        assertEquals("Enkei", rim.getBrandName());
    }

    @Test
    void createRim_withZeroStock_shouldReturnRimWithZeroStock() {
        Rim rim = RimFactory.createRim(
                "SSR", "SSR789", 20.0f, "5x114.3", 5, 114.3f, BigDecimal.valueOf(4000.00), 0, "http://example.com/rim4.jpg"
        );
        assertEquals(0, rim.getStockQuantity());
    }
}