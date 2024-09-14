package topco.market.order.controller.model;

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
