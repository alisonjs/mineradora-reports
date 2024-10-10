package org.br.mineradora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class OpportunityDTO {

    private long proposalId;

    private String customer;

    private BigDecimal priceTon;

    private BigDecimal lastDollarQuotation;

}
