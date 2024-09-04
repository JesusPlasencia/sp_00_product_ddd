package topco.market.product.infrastructure;

import org.springframework.data.repository.CrudRepository;
import topco.market.product.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
