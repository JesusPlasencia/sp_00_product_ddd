package topco.market.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topco.market.product.infrastructure.ProductRepository;

@Service
@RequiredArgsConstructor
public class OrderingService {

    private ProductRepository productRepository;

    private String getNextProductNumber() {
        Long productNumber = productRepository.getProductIdFromSequenceTable();
        return String.format("%06X", productNumber);
    }

}
