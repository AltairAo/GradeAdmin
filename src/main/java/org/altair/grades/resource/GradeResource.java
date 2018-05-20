package org.altair.grades.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.altair.grades.domain.Grades;
import org.apache.log4j.Logger;

@Path("grade")
public class GradeResource {
	private static final Logger LOGGER = Logger.getLogger(GradeResource.class);

	@Path("/saveGrades")
	@POST 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	public void saveGrade(final Grades grade) {

	}
	
	/*@Path("/saveGrades")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	
	public void saveGrade(@PathParam("id") Long id) {
		
		Grades grade = new Grades();
		grade.setId(id);
		System.out.println(grade.getId());
		//gradeService.saveGrade(grade);

	}*/
	
	@Path("/updateGrades")
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	public void updateGrade(final Grades grade) {
		
	}
}
