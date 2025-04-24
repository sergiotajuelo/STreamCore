package es.sergiotajuelo.streamscore.accountservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    private String id;
    private String name;
    private String symbol;
}