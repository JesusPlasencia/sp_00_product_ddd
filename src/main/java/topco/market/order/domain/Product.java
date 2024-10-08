package topco.market.order.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Id
    private String id;
    private String name;
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
