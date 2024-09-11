package topco.market.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topco.market.product.infrastructure.ProductRepository;

@Service
@RequiredArgsConstructor
public class OrderingService {

    private final ProductRepository productRepository;

}
