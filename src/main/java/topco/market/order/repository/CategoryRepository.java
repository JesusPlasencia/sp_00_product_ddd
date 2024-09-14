package topco.market.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import topco.market.order.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, String>, PagingAndSortingRepository<Category, String> {

}
