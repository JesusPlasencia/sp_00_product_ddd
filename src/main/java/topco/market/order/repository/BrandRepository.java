package topco.market.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import topco.market.order.domain.Brand;

public interface BrandRepository extends CrudRepository<Brand, String>, PagingAndSortingRepository<Brand, String> {

}
