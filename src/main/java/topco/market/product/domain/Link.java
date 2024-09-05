package topco.market.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_PRODUCT_IMAGE")
public class Link {

    @Id
    private String id;

    private String link;

}
