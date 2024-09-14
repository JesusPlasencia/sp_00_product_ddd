package topco.market.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topco.market.order.domain.Product;
import topco.market.order.repository.ProductRepository;

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
