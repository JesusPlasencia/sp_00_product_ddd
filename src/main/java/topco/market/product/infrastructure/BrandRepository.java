package topco.market.product.infrastructure;

import org.springframework.data.repository.CrudRepository;
import topco.market.product.domain.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}
