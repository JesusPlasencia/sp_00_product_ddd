package topco.market.product.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import topco.market.product.domain.Brand;

public interface BrandRepository extends CrudRepository<Brand, String>, PagingAndSortingRepository<Brand, String> {

}
