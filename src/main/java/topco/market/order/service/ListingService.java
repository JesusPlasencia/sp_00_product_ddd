package topco.market.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import topco.market.order.domain.Brand;
import topco.market.order.domain.Category;
import topco.market.order.domain.Product;
import topco.market.order.repository.BrandRepository;
import topco.market.order.repository.CategoryRepository;
import topco.market.order.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    // PRODUCT BY ID
    public Product showProductById (String productId) {
        Optional<Product> lookup = productRepository.findById(productId);
        return lookup.orElse(null);
    }

    // CATEGORY
    public List<Category> showCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    // BRAND
    public List<Brand> showBrands() {
        return (List<Brand>) brandRepository.findAll();
    }

    // PRODUCT COUNT GENERAL
    public Integer showProductCount() {
        return productRepository.getProductCount();
    }

    // PRODUCT COUNT BY CATEGORY
    public Integer showProductCountByCategory(String categoryId) {
        return productRepository.getProductCountByCategory(categoryId);
    }

    // PRODUCT COUNT BY BRAND
    public Integer showProductCountByBrand(String brandId) {
        return productRepository.getProductCountByBrand(brandId);
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
