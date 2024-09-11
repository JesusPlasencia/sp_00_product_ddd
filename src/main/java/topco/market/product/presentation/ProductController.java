package topco.market.product.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import topco.market.product.domain.Product;

import topco.market.product.application.ListingService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ListingService listingService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> listOfProducts = listingService.showProducts(pageId);
        return ResponseEntity.ok(listOfProducts);
    }

    @GetMapping("searchByCategory")
    public ResponseEntity<List<Product>> getProductsByCategory(
            @RequestParam(defaultValue = "", name = "catid") String categoryId,
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> listOfProducts = listingService.showProductsByCategory(pageId, categoryId);
        return ResponseEntity.ok(listOfProducts);
    }

    @GetMapping("searchByBrand")
    public ResponseEntity<List<Product>> getProductsByBrand(
            @RequestParam(defaultValue = "", name = "bid") String brandId,
            @RequestParam(defaultValue = "0", name = "pgid") int pageId //Page No
    ) {
        List<Product> listOfProducts = listingService.showProductsByBrand(pageId, brandId);
        return ResponseEntity.ok(listOfProducts);
    }

}
