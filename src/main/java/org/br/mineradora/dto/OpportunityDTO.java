package org.br.mineradora.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class OpportunityDTO {

    private long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private BigDecimal lastDollarQuotation;

}
