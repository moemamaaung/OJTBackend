package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.AcademicYear;
import com.hostmdy.hmi.domain.Course;
import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.repository.CourseRepository;
import com.hostmdy.hmi.repository.ProgramRepository;
import com.hostmdy.hmi.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	private final CourseRepository courseRepository;
	private final ProgramRepository programRepository;

	
	
	public CourseServiceImpl(CourseRepository courseRepository, ProgramRepository programRepository) {
		super();
		this.courseRepository = courseRepository;
		this.programRepository = programRepository;
		
	}
	
	@Override
	public Optional<Course> findById(Long id) {
		// TODO Auto-generated method stub
		
		return courseRepository.findById(id);
	}

//	@Override
//	public Optional<Course> findBySubjectName(String subjectName) {
//		// TODO Auto-generated method stub
//		return courseRepository.findBySubjectName(subjectName);
//	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
		
		
	}


	@Override
	public Course createCourse(Course course,Long programId) {
		// TODO Auto-generated method stub
		System.out.println("programId "+programId);
		Optional<Program> programOpt = programRepository.findById(programId);
		if(programOpt.isPresent()) {
			Program program = programOpt.get();
			
			program.getCourse().add(course);
			course.setProgram(program);
	
		}

		return courseRepository.save(course);
	}


	@Override
	public Course updateCourse(Course course,Long programId) {
		// TODO Auto-generated method stub
		Optional<Program> programOpt = programRepository.findById(programId);
		if(programOpt.isPresent()) {
			Program program = programOpt.get();
			
			program.getCourse().add(course);
			course.setProgram(program);
	
		}
		return courseRepository.save(course);
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return (List<Course>) courseRepository.findAll();
	}

}
