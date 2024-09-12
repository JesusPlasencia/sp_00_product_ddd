package topco.market.product.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import topco.market.product.domain.Product;

import topco.market.product.application.ListingService;
import topco.market.product.presentation.model.Count;
import topco.market.product.presentation.model.Items;

import java.util.List;


@RestController
@RequestMapping("PRODUCTS")
@RequiredArgsConstructor
public class ProductController {

    private final ListingService listingService;

    @GetMapping("/COUNT")
    public ResponseEntity<Count> getProductCount() {
        int count = listingService.showProductCount();
        return ResponseEntity.ok(Count.builder().results(count).build());
    }

    @GetMapping("/EXTRACT")
    public ResponseEntity<Items<Product>> getProducts(
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> products = listingService.showProducts(pageId);
        return ResponseEntity.ok(Items.<Product>builder().items(products).build());
    }

    @GetMapping("SEARCH_BY_CATEGORY")
    public ResponseEntity<Items<Product>> getProductsByCategory(
            @RequestParam(defaultValue = "", name = "catid") String categoryId,
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> products = listingService.showProductsByCategory(pageId, categoryId);
        return ResponseEntity.ok(Items.<Product>builder().items(products).build());
    }

    @GetMapping("SEARCH_BY_BRAND")
    public ResponseEntity<Items<Product>> getProductsByBrand(
            @RequestParam(defaultValue = "", name = "bid") String brandId,
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> products = listingService.showProductsByBrand(pageId, brandId);
        return ResponseEntity.ok(Items.<Product>builder().items(products).build());
    }

}
