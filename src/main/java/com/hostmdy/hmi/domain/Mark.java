package com.hostmdy.hmi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Mark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer subject1Score;
	private Integer subject2Score;
	private Integer subject3Score;
	private Integer subject4Score;
	private Integer subject5Score;
	private Integer subject6Score;
	private String fullname;
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	//@JsonIgnore
	private Course course;
	
//	@ManyToOne
//	@JoinColumn(name = "examId")
//	private Exam exam;
}
