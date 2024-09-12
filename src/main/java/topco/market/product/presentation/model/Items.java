package topco.market.product.presentation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Items<T> {

    private List<T> items;

}
