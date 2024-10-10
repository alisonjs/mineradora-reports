package org.br.mineradora.controller;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.service.OpportunityService;

import java.util.List;

@Path("/api/opportunity")
@Authenticated
public class OpportunityController {

    @Inject
    OpportunityService opportunityService;

    @GET
    @Path("/data")
    public List<OpportunityDTO> generateReport(){
        return opportunityService.generateOpportunityData();
    }

}
