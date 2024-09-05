package topco.market.product.domain.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import topco.market.product.domain.Category;
import topco.market.product.domain.Product;

import java.util.List;

@Builder
@Getter
@Setter
public class ProductList {

    private List<Product> items;
    private List<Category> categories;

}
