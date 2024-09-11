package topco.market.product.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import topco.market.product.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, String>, PagingAndSortingRepository<Category, String> {

}
