package org.altair.grades.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.altair.grades.domain.Grades;
import org.altair.grades.domain.lists.GradeList;
import org.altair.grades.services.GradeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Path("grade")
public class GradeResource {
	private static final Logger LOGGER = Logger.getLogger(GradeResource.class);
	@Autowired
	private GradeService gradeService;

	@Path("/saveGrades")
	@POST 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	public Grades saveGrade(final Grades grade) {
		System.out.println(grade);
		
		return gradeService.saveGrade(grade);

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
		GradeResource.LOGGER.debug(grade);
		gradeService.updateGrade(grade);

	}
	@Path("/getAllGrades")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public GradeList getGrades() {
		final GradeList gradeList = gradeService.getGrades();
		GradeResource.LOGGER.debug(gradeList);
		return gradeList;

	}
	@Path("/CalAllAVG")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public GradeList calAllAVG() {

		final GradeList gradeList = gradeService.CalAllAVG();
		GradeResource.LOGGER.debug(gradeList);
		return gradeList;

	}
	@Path("/CalSingleAVG")
	@POST
	@Produces({ MediaType.TEXT_XML })
	@Consumes({ MediaType.TEXT_XML })
	public String CalSingleAVG(String item) {
		int singleAVG = gradeService.CalSingleAVG(item);	
		return String.valueOf(singleAVG);

	}
	@Path("/CalRank")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public GradeList CalRank() {
		final GradeList gradeList = gradeService.calRank();
		GradeResource.LOGGER.debug(gradeList);
		return gradeList;

	}
	@Path("/IndicateByPart")
	@POST
	@Produces({ MediaType.TEXT_XML})
	@Consumes({ MediaType.TEXT_XML})
	public String IndicateByPart(String part) {
		String x=gradeService.IndicateByPart(part);
		return x;
		

	}
}
