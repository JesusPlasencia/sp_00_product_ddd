package topco.market.product.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import topco.market.product.domain.Product;

public interface ProductRepository extends CrudRepository<Product, String>, PagingAndSortingRepository<Product, String> {

    @Query("select next value for S_PRODUCT_NUMBER from DUAL_PRODUCT_NUMBER")
    Long getProductIdFromSequenceTable();

    @Query("select p from Product p where p.category.id = ?1")
    Page<Product> findByCategory(String categoryId, PageRequest pageRequest);

    @Query("select p from Product p where p.brand.id = ?1")
    Page<Product> findByBrand(String brandId, PageRequest pageRequest);

}
