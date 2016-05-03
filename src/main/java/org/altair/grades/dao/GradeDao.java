package org.altair.grades.dao;

import java.util.List;

import org.altair.grades.domain.Grades;

public interface GradeDao {
	public List<Grades> findAll();

	public List<Grades> findAll(final boolean isPaging, final int firstResult,
			final int maxResults);
	
	public Grades save(Grades grade);
	
	public void updateGrade(Grades grade);
	
	public void updateAVG(Grades grade);

	public void updateRank(Grades grade);

	public List IndicateByPart(String sql);
	
	
	
	
}
