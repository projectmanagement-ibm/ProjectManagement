package com.example.projectv1.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project implements Serializable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="project_description")
	private String projectDescripion;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="status")
	private String status;

	public Project() {
		super();
	}

	public Project(int id, String name, String projectDescripion, Date startDate, Date endDate, String status) {
		super();
		this.id = id;
		this.name = name;
		this.projectDescripion = projectDescripion;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectDescripion() {
		return projectDescripion;
	}

	public void setProjectDescripion(String projectDescripion) {
		this.projectDescripion = projectDescripion;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", projectDescripion=" + projectDescripion + ", startDate="
				+ startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}

}
