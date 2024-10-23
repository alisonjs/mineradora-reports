package org.br.mineradora.controller;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.service.OpportunityService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;

@Path("/api/opportunity")
@Authenticated
@Slf4j
public class OpportunityController {

    @Inject
    OpportunityService opportunityService;

    @Inject
    JsonWebToken jsonWebToken;

    @GET
    @RolesAllowed({"user", "manager"})
    public List<OpportunityDTO> list(){
        return opportunityService.generateOpportunityData();
    }
}

