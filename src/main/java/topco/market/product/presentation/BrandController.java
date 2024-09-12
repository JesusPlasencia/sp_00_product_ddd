package topco.market.product.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import topco.market.product.application.ListingService;
import topco.market.product.domain.Brand;
import topco.market.product.domain.Category;
import topco.market.product.presentation.model.Items;

import java.util.List;

@RestController
@RequestMapping("BRANDS")
@RequiredArgsConstructor
public class BrandController {

    private final ListingService listingService;

    @GetMapping("/EXTRACT")
    public ResponseEntity<Items<Brand>> getProducts() {
        List<Brand> brands = listingService.showBrands();
        return ResponseEntity.ok(Items.<Brand>builder().items(brands).build());
    }
}
