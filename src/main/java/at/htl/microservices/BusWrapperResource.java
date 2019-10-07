package at.htl.microservices;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.Decorator;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface BusWrapperResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/bus")
    JsonArray getBuses();
}
