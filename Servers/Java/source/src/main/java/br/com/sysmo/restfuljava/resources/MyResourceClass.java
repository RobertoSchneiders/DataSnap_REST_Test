/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysmo.restfuljava.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Eurides
 */
@Path("/TServerMethods1")
public class MyResourceClass {

    @GET
    @Path("/HelloWorld")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject  HelloWorld() throws JSONException {
        return new JSONObject().put("result", "[Hello World!]");
    }

    @GET
    @Path("/EchoStringTextPlain/{str}")
    @Produces(MediaType.TEXT_PLAIN)
    public String EchoStringTextPlain(@PathParam("str") String str) throws Exception {
        return "{'result':['" + str + "']}";
    }

    @GET
    @Path("/EchoStringApplicationJSON/{str}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject EchoStringApplicationJSON(@PathParam("str") String str) throws JSONException {
        return new JSONObject().put("result", str);
    }

    @GET
    @Path("/SampleTest")
    @Produces(MediaType.TEXT_PLAIN)
    public Response SampleTest() {
        return Response.ok("This is a simple test, using Response for returning").build();
    }

    @GET
    @Path("/EchoFactorial/{nro}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject EchoFatorial(@PathParam("nro") int num) throws JSONException {
        double fat = 1;
        for (int i = 2; i <= num; i++) {
            fat *= i;
        }

        return new JSONObject().put("Number", num).put("Factorial", fat);
    }    
}
