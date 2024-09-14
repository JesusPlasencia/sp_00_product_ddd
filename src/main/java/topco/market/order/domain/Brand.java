package topco.market.order.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_BRAND")
public class Brand {

    @Id
    private String id;
    private String name;

}
