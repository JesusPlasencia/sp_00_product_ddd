package topco.market.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import topco.market.product.domain.Brand;
import topco.market.product.domain.Category;
import topco.market.product.domain.Product;
import topco.market.product.infrastructure.BrandRepository;
import topco.market.product.infrastructure.CategoryRepository;
import topco.market.product.infrastructure.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    // CATEGORY
    public List<Category> showCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    // BRAND
    public List<Brand> showBrands() {
        return (List<Brand>) brandRepository.findAll();
    }

    // PRODUCT
    public Integer showProductCount() {
        return productRepository.getProductCount();
    }

    public List<Product> showProducts(int pageId) {
        Page<Product> result = productRepository.findAll(PageRequest.of(
                pageId, 40
        ));
        return result.getContent();
    }

    public List<Product> showProductsByCategory(int pageId, String categoryId) {
        Page<Product> result = productRepository.findByCategory(categoryId, PageRequest.of(
                pageId, 40
        ));
        return result.getContent();
    }

    public List<Product> showProductsByBrand(int pageId, String brandId) {
        Page<Product> result = productRepository.findByBrand(brandId, PageRequest.of(
                pageId, 40
        ));
        return result.getContent();
    }

}
