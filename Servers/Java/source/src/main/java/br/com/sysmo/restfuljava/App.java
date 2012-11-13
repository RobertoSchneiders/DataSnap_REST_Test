package br.com.sysmo.restfuljava;

import com.sun.grizzly.comet.CometAsyncFilter;
import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;

/**
 * RESTFul-java!
 *
 * @author Eurides
 */
public class App {

    
    public static final URI BASE_URI = getBaseURI();

    private static int getPort(int defaultPort) {
        String port = System.getenv("JERSEY_HTTP_PORT");
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
            }
        }
        return defaultPort;
    }

    private static URI getBaseURI() {
        try {
            InetAddress IP = InetAddress.getLocalHost();
            return UriBuilder.fromUri("http://" + IP.getHostAddress() + "/").port(getPort(777)).build();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static void main(String[] args) throws IOException {
        //creating de service
        System.out.println("Instantiating the service...");
        GrizzlyWebServer gws = new GrizzlyWebServer(BASE_URI.getPort(), BASE_URI.getHost());
        //gws.addAsyncFilter(new CometAsyncFilter());
        
        // Jersey web resources
        // Adding restlet servlet
        System.out.println("Setting the Servlet and Adapter...");
        ServletAdapter jerseyAdapter = new ServletAdapter();
        jerseyAdapter.addInitParameter("com.sun.jersey.config.property.packages", "br.com.sysmo.restfuljava.resources");
        
        // this is the magic restlet servlet
        jerseyAdapter.setContextPath("/");
        jerseyAdapter.setProperty(ServletAdapter.LOAD_ON_STARTUP, 1);
        jerseyAdapter.setServletInstance(new ServletContainer());
        gws.addGrizzlyAdapter(jerseyAdapter, new String[]{"/"});

        // let Grizzly run
        System.out.println("Starting de server...\n\n");
        gws.start();
        System.out.println(
            String.format("\n\nServer running, visit %sapplication.wadl\n"
                + "Try out %sTServerMethods1/SampleTest\n"
                + "Hit [ENTER] to stop it...", BASE_URI, BASE_URI));

        System.in.read();
        System.out.println("Stopping server...");

        gws.stop();
        System.out.println("Server stopped...");

    }

}
