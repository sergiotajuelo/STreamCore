package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyEntity {

    @Id
    @Column(name = "currency_id", length = 3)
    private String currencyId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "symbol", nullable = false, length = 5)
    private String symbol;
}
