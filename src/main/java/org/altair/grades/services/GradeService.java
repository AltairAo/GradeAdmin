package org.altair.grades.services;

import org.altair.grades.domain.Grades;
import org.altair.grades.domain.lists.GradeList;

public interface GradeService {
	public GradeList getGrades();

	public GradeList CalAllAVG();
	
	public int CalSingleAVG(String courseName);
	
	public Grades saveGrade(Grades grade);
	
	public void updateGrade(Grades grade);

	public GradeList calRank();

	public String IndicateByPart(String part);
	
}
