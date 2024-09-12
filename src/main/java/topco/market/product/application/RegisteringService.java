package topco.market.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topco.market.product.domain.Product;
import topco.market.product.infrastructure.ProductRepository;

@Service
@RequiredArgsConstructor
public class RegisteringService {

    private final ProductRepository productRepository;

    public String createProduct(Product product) {
        return null;
    }

    private String getNextProductNumber() {
        Long productNumber = productRepository.getNextProductNumber();
        return String.format("%06X", productNumber);
    }

}
