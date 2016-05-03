package org.altair.grades.dao.impl;

import java.util.List;

import org.altair.grades.dao.GradeDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.altair.grades.domain.Grades;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GradeDaoImpl implements GradeDao {
	private static final Logger LOGGER = Logger.getLogger(GradeDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public GradeDaoImpl() {
	}

	public List<Grades> findAll() {
		return findAll(false, 0, 0);
	}

	public List<Grades> findAll(final boolean isPaging, final int firstResult,
			final int maxResults) {
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Grades> cq = cb.createQuery(Grades.class);
		final TypedQuery<Grades> q = entityManager.createQuery(cq);
		if (isPaging) {
			q.setMaxResults(maxResults);
			q.setFirstResult(firstResult);
		}
		return q.getResultList();
	}

	@Transactional
	public Grades save(final Grades grade) {
		return entityManager.merge(grade);
	}
	@Transactional
	public void updateGrade(final Grades grade){
		entityManager.merge(grade);
		/*String sql = "UPDATE grade_info g SET g.CGrade=?, g.MGrade=?,g.EGrade=?,g.LAGrade=?,g.AVGGrade=? WHERE g.id=?";
		Query query=entityManager.createNativeQuery(sql);
		query.setParameter(1, grade.getCGrade());
		query.setParameter(2, grade.getMGrade());
		query.setParameter(3, grade.getEGrade());
		query.setParameter(4, grade.getLAGrade());
		query.setParameter(5, (grade.getCGrade()+grade.getMGrade()+grade.getEGrade()+grade.getLAGrade())/4);
		query.setParameter(6, grade.getId());
		query.executeUpdate();
		entityManager.flush();*/
	}
	@Transactional
	public void updateAVG(final Grades grade) {
		final StringBuilder jpql = new StringBuilder();
		jpql.append("UPDATE Grades g SET g.AVGGrade='").append(
				grade.getAVGGrade());
		jpql.append("' WHERE g.id=").append(grade.getId());
		entityManager.createQuery(jpql.toString()).executeUpdate();
	}
	@Transactional
	public void updateRank(final Grades grade){
		String sql = "UPDATE grade_info g SET g.Rank=? WHERE g.id=?";
		Query query=entityManager.createNativeQuery(sql);
		query.setParameter(1, grade.getRank());
		query.setParameter(2, grade.getId());
		query.executeUpdate();
		entityManager.flush();
		
	}
	@Transactional
	public List IndicateByPart(String sql){
		Query query=entityManager.createNativeQuery(sql);
		
		return query.getResultList();
		
	}
}
