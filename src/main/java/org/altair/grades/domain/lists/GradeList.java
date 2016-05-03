package org.altair.grades.domain.lists;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.altair.grades.domain.Grades;

@XmlRootElement(name = "GradeList")
public class GradeList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4124068310671630531L;
	private List<Grades> gradeList;

	public GradeList() {
	}

	public GradeList(final List<Grades> gradeList) {
		super();
		this.gradeList = gradeList;
	}

	@XmlElement(name = "Grades")
	@XmlElementWrapper
	public List<Grades> getGradeList() {
		return gradeList;
	}

	public void setRecordList(final List<Grades> gradeList) {
		this.gradeList = gradeList;
	}

	@Override
	public String toString() {
		return "{" + gradeList + "}";
	}

}
