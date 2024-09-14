package topco.market.order.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_CATEGORY")
public class Category {

    @Id
    private String id;
    private String label;
    private String name;

}
