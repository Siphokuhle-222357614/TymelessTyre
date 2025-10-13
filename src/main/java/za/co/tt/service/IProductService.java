package za.co.tt.service;

import za.co.tt.domain.Product;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IProductService extends IService<Product, Long>{

    Optional<Product> findByProductId(Long id); //just a placeholder
}
