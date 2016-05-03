package org.altair.grades;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * <p>AirResourceConfig class.</p>
 *
 * @author hanl
 * @version $Id: $Id
 */
@ApplicationPath("/gradeadmin/*")
public class AirResourceConfig extends ResourceConfig {
    /**
     * <p>Constructor for AirResourceConfig.</p>
     */
    public AirResourceConfig() {
        packages("org.altair.grades.resource");
        
        /**register(BookResource.class);**/
    }   
}