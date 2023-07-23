package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.Course;
import com.hostmdy.hmi.domain.Exam;
import com.hostmdy.hmi.domain.Mark;
import com.hostmdy.hmi.repository.CourseRepository;
import com.hostmdy.hmi.repository.ExamRepository;
import com.hostmdy.hmi.repository.MarkRepository;
import com.hostmdy.hmi.service.MarkService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService{
	
	private final MarkRepository markRepository;
	private final CourseRepository courseRepository;
	private final ExamRepository examRepository;
	

	@Override
	public List<Mark> findAll() {
		// TODO Auto-generated method stub
		return (List<Mark>) markRepository.findAll();
	}

	@Override
	public Mark create(Mark mark,Long courseId) {
		// TODO Auto-generated method stub
		
    Optional<Course> courseOpt = courseRepository.findById(courseId);
    
//    Optional<Exam> examOpt = examRepository.findById(examId);
				
		if(courseOpt.isPresent() ) {
			Course course = courseOpt.get();
//			Exam exam = examOpt.get();
			course.getMarks().add(mark);
//			exam.getMarks().add(mark);
			mark.setCourse(course);
//			mark.setExam(exam);

			return markRepository.save(mark);
		}
	return null;	
	}

	@Override
	public Mark updateMark(Mark mark,Long courseId ) {
		// TODO Auto-generated method stub
		 Optional<Course> courseOpt = courseRepository.findById(courseId);
		// Optional<Exam> examOpt = examRepository.findById(examId);
		
		if(courseOpt.isPresent()) {
			Course course = courseOpt.get();
//			Exam exam = examOpt.get();
			
			course.getMarks().add(mark);
			//exam.getMarks().add(mark);
			
			mark.setCourse(course);
			//mark.setExam(exam);

			return markRepository.save(mark);
			
		}
		return null;
	}

	@Override
	public Optional<Mark> findById(Long id) {
		// TODO Auto-generated method stub
		return markRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		markRepository.deleteById(id);
	}

}
