package org.altair.grades.services.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.altair.grades.dao.GradeDao;
import org.altair.grades.domain.Grades;
import org.altair.grades.domain.lists.GradeList;
import org.altair.grades.services.GradeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
	private static final Logger LOGGER = Logger.getLogger(GradeService.class);
	@Autowired
	private GradeDao gradeDao;

	public GradeServiceImpl() {
	}

	public GradeList getGrades() {
		return new GradeList(gradeDao.findAll());
	}

	public Grades saveGrade(Grades grade) {
		return gradeDao.save(grade);
	}

	public void updateGrade(Grades grade) {
		gradeDao.updateGrade(grade);
	}

	public GradeList CalAllAVG() {
		List<Grades> gradeList = gradeDao.findAll();
		for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
			Grades grade = (Grades) iter.next();

			grade.setAVGGrade((grade.getCGrade() + grade.getEGrade()
					+ grade.getMGrade() + grade.getLAGrade()) / 4);
			gradeDao.updateAVG(grade);

		}
		return new GradeList(gradeDao.findAll());
	}

	public int CalSingleAVG(String courseName) {
		int totalGrade = 0;
		List<Grades> gradeList = gradeDao.findAll();
		if (courseName.equals("0")) {
			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
				Grades grade = (Grades) iter.next();
				totalGrade += grade.getCGrade();

			}

		} else if (courseName.equals("1")) {
			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
				Grades grade = (Grades) iter.next();
				totalGrade += grade.getMGrade();

			}

		} else if (courseName.equals("2")) {
			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
				Grades grade = (Grades) iter.next();
				totalGrade += grade.getEGrade();

			}

		} else if (courseName.equals("3")) {
			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
				Grades grade = (Grades) iter.next();
				totalGrade += grade.getLAGrade();

			}

		}

		return totalGrade / (gradeList.size());
	}

	public GradeList calRank() {
		int i = 1;
		List<Grades> gradeList = gradeDao.findAll();
		Collections.sort(gradeList, new Comparator<Grades>() {
			public int compare(Grades arg0, Grades arg1) {
				int avg0 = arg0.getAVGGrade();
				int avg1 = arg1.getAVGGrade();
				if (avg1 > avg0) {
					return 1;
				} else if (avg1 == avg0) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		for (Iterator iter = gradeList.iterator(); iter.hasNext();) {

			Grades grade = (Grades) iter.next();
			grade.setRank(i++);
			gradeDao.updateRank(grade);
		}
		return new GradeList(gradeList);

	}

	public String IndicateByPart(String part) {
		System.out.println(part);
		String numbers = "0";
		String sql = "";
		if (part.equals("radio1radio6")) {
			sql = "select count(*) from grade_info g where g.CGrade<60";
		} else if (part.equals("radio1radio7")) {
			sql = "select count(*) from grade_info g where g.CGrade>=60 and g.CGrade<70";
		} else if (part.equals("radio1radio8")) {
			sql = "select count(*) from grade_info g where g.CGrade>=70 and g.CGrade<80";
		} else if (part.equals("radio1radio9")) {
			sql = "select count(*) from grade_info g where g.CGrade>=80 and g.CGrade<90";
		} else if (part.equals("radio1radio10")) {
			sql = "select count(*) from grade_info g where g.CGrade>=90 and g.CGrade<=100";
		} else if (part.equals("radio2radio6")) {
			sql = "select count(*) from grade_info g where g.MGrade<60";
		} else if (part.equals("radio2radio7")) {
			sql = "select count(*) from grade_info g where g.MGrade>=60 and g.MGrade<70";
		} else if (part.equals("radio2radio8")) {
			sql = "select count(*) from grade_info g where g.MGrade>=70 and g.MGrade<80";
		} else if (part.equals("radio2radio9")) {
			sql = "select count(*) from grade_info g where g.MGrade>=80 and g.MGrade<90";
		} else if (part.equals("radio2radio10")) {
			sql = "select count(*) from grade_info g where g.MGrade>=90 and g.MGrade<=100";
		} else if (part.equals("radio3radio6")) {
			sql = "select count(*) from grade_info g where g.EGrade<60";
		} else if (part.equals("radio3radio7")) {
			sql = "select count(*) from grade_info g where g.EGrade>=60 and g.EGrade<70";
		} else if (part.equals("radio3radio8")) {
			sql = "select count(*) from grade_info g where g.EGrade>=70 and g.EGrade<80";
		} else if (part.equals("radio3radio9")) {
			sql = "select count(*) from grade_info g where g.EGrade>=80 and g.EGrade<90";
		} else if (part.equals("radio3radio10")) {
			sql = "select count(*) from grade_info g where g.EGrade>=90 and g.EGrade<=100";
		} else if (part.equals("radio4radio6")) {
			sql = "select count(*) from grade_info g where g.LAGrade<60";
		} else if (part.equals("radio4radio7")) {
			sql = "select count(*) from grade_info g where g.LAGrade>=60 and g.LAGrade<70";
		} else if (part.equals("radio4radio8")) {
			sql = "select count(*) from grade_info g where g.LAGrade>=70 and g.LAGrade<80";
		} else if (part.equals("radio4radio9")) {
			sql = "select count(*) from grade_info g where g.LAGrade>=80 and g.LAGrade<90";
		} else if (part.equals("radio4radio10")) {
			sql = "select count(*) from grade_info g where g.LAGrade>=90 and g.LAGrade<=100";
		} else if (part.equals("radio5radio6")) {
			sql = "select count(*) from grade_info g where g.AVGGrade<60";
		} else if (part.equals("radio5radio7")) {
			sql = "select count(*) from grade_info g where g.AVGGrade>=60 and g.AVGGrade<70";
		} else if (part.equals("radio5radio8")) {
			sql = "select count(*) from grade_info g where g.AVGGrade>=70 and g.AVGGrade<80";
		} else if (part.equals("radio5radio9")) {
			sql = "select count(*) from grade_info g where g.AVGGrade>=80 and g.AVGGrade<90";
		} else if (part.equals("radio5radio10")) {
			sql = "select count(*) from grade_info g where g.AVGGrade>=90 and g.AVGGrade<=100";
		}
		List<?> list = gradeDao.IndicateByPart(sql);
		numbers = list.get(0).toString();
		return numbers;
	}
}
