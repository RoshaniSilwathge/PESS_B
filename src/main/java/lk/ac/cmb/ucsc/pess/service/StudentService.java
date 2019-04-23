package lk.ac.cmb.ucsc.pess.service;

import java.util.List;

import lk.ac.cmb.ucsc.pess.dto.StudentInputDto;
import lk.ac.cmb.ucsc.pess.model.Student;

public interface StudentService {
	Student save(StudentInputDto studentInput);

	Student update(long studentId, StudentInputDto studentInput);

	List<Student> getAll();
	
	List<Student> getAllActive();
}
