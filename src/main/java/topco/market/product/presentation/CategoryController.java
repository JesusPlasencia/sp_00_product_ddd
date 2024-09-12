package topco.market.product.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import topco.market.product.application.ListingService;
import topco.market.product.domain.Category;
import topco.market.product.presentation.model.Items;

import java.util.List;

@RestController
@RequestMapping("CATEGORIES")
@RequiredArgsConstructor
public class CategoryController {

    private final ListingService listingService;

    @GetMapping("/EXTRACT")
    public ResponseEntity<Items<Category>> getProducts() {
        List<Category> categories = listingService.showCategories();
        return ResponseEntity.ok(Items.<Category>builder().items(categories).build());
    }

}
