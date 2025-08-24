package factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Tyre;
import za.co.tt.factory.TyreFactory;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TyreFactoryTest {

    @Test
    void createTyre_shouldReturnValidTyre() {
        Tyre tyre = TyreFactory.createTyre(
                "Continental", "Summer", 225, 45, 18, 17.5f, 650, "V", 2.4f,
                "C22545V", "E4", "High performance summer tyre", BigDecimal.valueOf(1500.00), 25, "http://example.com/tyre.jpg"
        );
        assertNotNull(tyre);
        assertEquals("Continental", tyre.getBrandName());
    }

    @Test
    void createTyre_withNullBrand_shouldReturnTyreWithNullBrand() {
        Tyre tyre = TyreFactory.createTyre(
                null, "Winter", 205, 55, 16, 16.0f, 600, "H", 2.2f,
                "W20555H", "E3", "Winter tyre", BigDecimal.valueOf(1200.00), 10, "http://example.com/tyre2.jpg"
        );
        assertNull(tyre.getBrandName());
    }

    @Test
    void updateTyre_shouldSetIdAndUpdateFields() {
        Tyre tyre = TyreFactory.updateTyre(
                1L, "Michelin", "All-Season", 215, 50, 17, 17.0f, 700, "W", 2.5f,
                "M21550W", "E2", "All season tyre", BigDecimal.valueOf(1600.00), 30, "http://example.com/tyre3.jpg"
        );
        assertEquals(1L, tyre.getId());
        assertEquals("Michelin", tyre.getBrandName());
    }

    @Test
    void createTyre_withNegativeStock_shouldReturnTyreWithNegativeStock() {
        Tyre tyre = TyreFactory.createTyre(
                "Goodyear", "Performance", 235, 40, 19, 18.0f, 680, "Y", 2.6f,
                "G23540Y", "E5", "Performance tyre", BigDecimal.valueOf(1800.00), -5, "http://example.com/tyre4.jpg"
        );
        assertEquals(-5, tyre.getStockQuantity());
    }
}