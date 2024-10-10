package org.br.mineradora.controller;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.ServerErrorException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.service.OpportunityService;

import java.util.Date;
import java.util.List;

@Path("/api/opportunity")
@Authenticated
@Slf4j
public class OpportunityController {

    @Inject
    OpportunityService opportunityService;

    @GET
    public List<OpportunityDTO> list(){
        return opportunityService.generateOpportunityData();
    }

    @GET
    @Path("/report")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReport(){
        try{
            return Response.ok(opportunityService.generateCSVOpportunityReport(),
                    MediaType.APPLICATION_OCTET_STREAM)
                    .header("content-disposition", "attachment; filename="+new Date()+"--selling-oppotunity.csv")
                    .build();
        } catch (ServerErrorException e) {
            log.error("Server error", e);
            return Response.serverError().build();
        }
    }
}
