package topco.market.product.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import topco.market.product.domain.Product;

public interface ProductRepository extends CrudRepository<Product, String>, PagingAndSortingRepository<Product, String> {

    @Query("select count(*) from Product")
    Integer getProductCount();

    @Query(value = "SELECT next value for S_PRODUCT_NUMBER", nativeQuery = true)
    Long getNextProductNumber();

    @Query("select p from Product p where p.category.id = ?1")
    Page<Product> findByCategory(String categoryId, PageRequest pageRequest);

    @Query("select p from Product p where p.brand.id = ?1")
    Page<Product> findByBrand(String brandId, PageRequest pageRequest);

}
