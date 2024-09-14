package topco.market.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import topco.market.order.domain.Product;

import topco.market.order.service.ListingService;
import topco.market.order.controller.model.Count;
import topco.market.order.controller.model.Items;

import java.util.List;


@RestController
@RequestMapping("PRODUCTS")
@RequiredArgsConstructor
public class ProductController {

    private final ListingService listingService;

    // IMPOSSIBLE SCENARIO
//    @GetMapping("/COUNT")
//    public ResponseEntity<Count> getProductCount() {
//        int count = listingService.showProductCount();
//        return ResponseEntity.ok(Count.builder().results(count).build());
//    }

    // IMPOSSIBLE SCENARIO
//    @GetMapping("/EXTRACT")
//    public ResponseEntity<Items<Product>> getProducts(
//            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
//    ) {
//        List<Product> products = listingService.showProducts(pageId);
//        return ResponseEntity.ok(Items.<Product>builder().items(products).build());
//    }

    @GetMapping("COUNT_BY_CATEGORY")
    public ResponseEntity<Count> countProductByCategory(
            @RequestParam(defaultValue = "", name = "catid") String categoryId
    ) {
        int count = listingService.showProductCountByCategory(categoryId);
        return ResponseEntity.ok(Count.builder().results(count).build());
    }

    @GetMapping("EXTRACT_BY_CATEGORY")
    public ResponseEntity<Items<Product>> extractProductsByCategory(
            @RequestParam(defaultValue = "", name = "catid") String categoryId,
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> products = listingService.showProductsByCategory(pageId, categoryId);
        return ResponseEntity.ok(Items.<Product>builder().items(products).build());
    }

    @GetMapping("COUNT_BY_BRAND")
    public ResponseEntity<Count> countProductByBrand(
            @RequestParam(defaultValue = "", name = "bid") String brandId
    ) {
        int count = listingService.showProductCountByBrand(brandId);
        return ResponseEntity.ok(Count.builder().results(count).build());
    }

    @GetMapping("EXTRACT_BY_BRAND")
    public ResponseEntity<Items<Product>> extractProductsByBrand(
            @RequestParam(defaultValue = "", name = "bid") String brandId,
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> products = listingService.showProductsByBrand(pageId, brandId);
        return ResponseEntity.ok(Items.<Product>builder().items(products).build());
    }

    @GetMapping("/EXTRACT")
    public ResponseEntity<Product> extractProductById(
            @RequestParam(name = "pid") String productId
    ) {
        Product product = listingService.showProductById(productId);
        if (product == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

}
