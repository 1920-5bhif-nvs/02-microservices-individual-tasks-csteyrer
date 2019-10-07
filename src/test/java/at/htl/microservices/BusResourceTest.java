package at.htl.microservices;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusResourceTest {

    private static Client client;
    private static WebTarget target;

    @BeforeAll
    public static void init(){
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8085/bus/allBuses");
    }

    @Test
    public void test01_getBuses(){
        Response response = target.request().get();
        assertEquals(response.getStatus(),200);
        JsonArray jsonArray  = response.readEntity(JsonArray.class);
        assertThat(jsonArray.getJsonObject(0).getString("busType"), is("Franz"));
        assertThat(jsonArray.getJsonObject(0).getString("driverName"), is("typ1"));
        assertThat(jsonArray.getJsonObject(0).getInt("id"), is(1));
        assertThat(jsonArray.getJsonObject(0).getJsonArray("tickets").size(), is(1));

    }
}
