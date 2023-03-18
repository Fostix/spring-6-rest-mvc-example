package learn.springframework.spring6restmvc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BeerOrder {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;
    @Version
    private Long version;

//    @NotNull
//    @NotBlank
//    @Size(max = 50)
//    @Column(length = 50)
//    private String beerName;
//    @NotNull
//    private BeerStyle beerStyle;
//    @NotNull
//    @NotBlank
//    @Size(max = 255)
//    private String upc;
//    private Integer quantityOnHand;
//    @NotNull
//    private BigDecimal price;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp updatedDate;

    public boolean isNew() {
        return this.id == null;
    }

    private String customerRef;
    @ManyToOne
    private Customer customer;
}
