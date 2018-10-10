package arduinoProject;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan
public class App implements WebMvcConfigurer {

    public static void main(String args[]) throws Exception {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(App.class);

        Server server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(webContext));
        servletContextHandler.addServlet(servletHolder, "/*");

        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }
}
