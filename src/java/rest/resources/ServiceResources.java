/*
    This file is part of the MapleQuestAdvisor planning tool    
    Copyleft (L) 2020 - 2021 RonanLana

    GNU General Public License v3.0

    Permissions of this strong copyleft license are conditioned on making available complete
    source code of licensed works and modifications, which include larger works using a licensed
    work, under the same license. Copyright and license notices must be preserved. Contributors
    provide an express grant of patent rights.
 */
package rest.resources;

import mqaservice.MQAService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author RonanLana
 */
public class ServiceResources {
    
    @GET
    @Path("/character/{id}")
    public Response getResponseCharacter(@PathParam("id") int cid) {
        return Response.status(Response.Status.OK).entity(MQAService.csvCharacter(cid)).build();
    }
    
    @GET
    @Path("/inventory/{id}")
    public Response getResponseInventory(@PathParam("id") int cid) {
        return Response.status(Response.Status.OK).entity(MQAService.csvInventory(cid)).build();
    }
    
    @GET
    @Path("/quest/{id}")
    public Response getResponseQuests(@PathParam("id") int cid) {
        return Response.status(Response.Status.OK).entity(MQAService.csvQuests(cid)).build();
    }
    
    @GET
    @Path("/rates")
    public Response getResponseRates() {
        return Response.status(Response.Status.OK).entity(MQAService.csvRates()).build();
    }
    
}
