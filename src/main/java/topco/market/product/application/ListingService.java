package topco.market.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topco.market.product.domain.Product;
import topco.market.product.infrastructure.ProductRepository;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ProductRepository productRepository;

    public Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }

}
