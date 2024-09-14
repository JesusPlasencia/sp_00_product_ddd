package topco.market.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topco.market.order.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class OrderingService {

    private final ProductRepository productRepository;

}
