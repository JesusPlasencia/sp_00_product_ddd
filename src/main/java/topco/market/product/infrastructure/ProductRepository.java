package topco.market.product.infrastructure;

import org.springframework.data.repository.CrudRepository;
import topco.market.product.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
