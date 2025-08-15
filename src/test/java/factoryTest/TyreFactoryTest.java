package factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Tyre;
import za.co.tt.factory.TyreFactory;

public class TyreFactoryTest {

    @Test
    public void testTyreFactory(){
        TyreFactory tyreFactory = new TyreFactory();
        Tyre tyre = tyreFactory.createTyre();
        System.out.println(tyre.toString());
        assert tyre == null;
    }
}
