package com.learn.e;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =  false, unique = true)
	private Long feedback_id;
	
	@Column(nullable =  false, length = 100)
	private String name;
	
	@Column(nullable =  false, length = 100)
	private String email;
	
	@Column(nullable = false)
	private Long user_id;
	
	@Column(nullable =  false, length = 100)
	private String feedback_data;

	public Long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(Long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFeedback_data() {
		return feedback_data;
	}

	public void setFeedback_data(String feedback_data) {
		this.feedback_data = feedback_data;
	}
	
	
}
