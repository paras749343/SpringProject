package com.learn.e;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =  false, unique = true)
	private Long course_id;
	
	@Column(nullable =  false, length = 100)
	private String course_name;
	
	@Column(nullable =  false, length = 100)
	private String course_resource;
	
	@Column(nullable =  false, length = 100)
	private String course_fee;
	
	@Column(nullable =  false, length = 100)
	private String course_desc;

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_resource() {
		return course_resource;
	}

	public void setCourse_resource(String course_resource) {
		this.course_resource = course_resource;
	}

	public String getCourse_fee() {
		return course_fee;
	}

	public void setCourse_fee(String course_fee) {
		this.course_fee = course_fee;
	}

	public String getCourse_desc() {
		return course_desc;
	}

	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}

}
