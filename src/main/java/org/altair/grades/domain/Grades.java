package org.altair.grades.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "grade_info")
@XmlRootElement(name = "grade")
public class Grades implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Long id;
	private String stuName;
	private int CGrade;
	private int MGrade;
	private int EGrade;
	private int LAGrade;
	private int AVGGrade;
	private int Rank;

	public Grades() {
		super();
	}
	public Grades(Long id, String stuName, int cGrade, int mGrade, int eGrade,
			int lAGrade, int aVGGrade, int rank) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.CGrade = cGrade;
		this.MGrade = mGrade;
		this.EGrade = eGrade;
		this.LAGrade = lAGrade;
		this.AVGGrade = aVGGrade;
		this.Rank = rank;
	}
	public Grades(Long id, String stuName, int cGrade, int mGrade, int eGrade,
			int lAGrade) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.CGrade = cGrade;
		this.MGrade = mGrade;
		this.EGrade = eGrade;
		this.LAGrade = lAGrade;
		
	}

	public Grades(Long id,int aVGGrade) {
		super();
		this.id = id;
		this.AVGGrade = aVGGrade;
		
	}
	@Id
	@Column(unique = true, nullable = false, name = "id")
	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length =45, nullable = false, name = "stuName")
	@XmlAttribute(name = "stuName")
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Column(name = "CGrade")
	@XmlAttribute(name = "CGrade")
	public int getCGrade() {
		return CGrade;
	}

	public void setCGrade(int cGrade) {
		this.CGrade = cGrade;
	}

	@Column(name = "MGrade")
	@XmlAttribute(name = "MGrade")
	public int getMGrade() {
		return MGrade;
	}

	public void setMGrade(int mGrade) {
		this.MGrade = mGrade;
	}

	@Column(name = "EGrade")
	@XmlAttribute(name = "EGrade")
	public int getEGrade() {
		return EGrade;
	}

	public void setEGrade(int eGrade) {
		this.EGrade = eGrade;
	}

	@Column(name = "LAGrade")
	@XmlAttribute(name = "LAGrade")
	public int getLAGrade() {
		return LAGrade;
	}

	public void setLAGrade(int lAGrade) {
		this.LAGrade = lAGrade;
	}

	@Column(name = "AVGGrade")
	@XmlAttribute(name = "AVGGrade")
	public int getAVGGrade() {
		return AVGGrade;
	}

	public void setAVGGrade(int aVGGrade) {
		this.AVGGrade = aVGGrade;
	}

	@Column(name = "Rank")
	@XmlAttribute(name = "Rank")
	public int getRank() {
		return Rank;
	}

	public void setRank(int rank) {
		this.Rank = rank;
	}

	@Override
	public String toString() {
		return "Grades [id=" + id + ", stuName=" + stuName + ", CGrade="
				+ CGrade + ", MGrade=" + MGrade + ", EGrade=" + EGrade
				+ ", LAGrade=" + LAGrade + ", AVGGrade=" + AVGGrade + ", Rank="
				+ Rank + "]";
	}

	
	

}
