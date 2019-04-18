package lk.ac.cmb.ucsc.pess.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lk.ac.cmb.ucsc.pess.dto.StudentInputDto;
import lk.ac.cmb.ucsc.pess.exception.ResourceNotFoundException;
import lk.ac.cmb.ucsc.pess.model.Project;
import lk.ac.cmb.ucsc.pess.model.Student;
import lk.ac.cmb.ucsc.pess.model.UserCredential;
import lk.ac.cmb.ucsc.pess.model.UserRole;
import lk.ac.cmb.ucsc.pess.repository.ProjectRepository;
import lk.ac.cmb.ucsc.pess.repository.StudentRepository;
import lk.ac.cmb.ucsc.pess.repository.UserCredentialRepository;
import lk.ac.cmb.ucsc.pess.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private UserCredentialRepository userCredentialRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Student save(StudentInputDto studentInput) {
		UserCredential userCredential = userCredentialRepository.save(new UserCredential(studentInput.getIndexNo(),
				passwordEncoder.encode("zaq1xsw2@"), UserRole.STUDENT, true));
		Project project = projectRepository.findById(studentInput.getProjectId()).get();
		return studentRepository.save(new Student(studentInput.getEmail(), studentInput.getTelephone(), userCredential,
				studentInput.getRegNo(), studentInput.getIndexNo(), studentInput.getNic(), studentInput.getFullName(),
				studentInput.getInitials(), studentInput.getSurname(), project));
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student update(long studentId, StudentInputDto studentInput) {
		Optional<Student> savedStudent = studentRepository.findById(studentId);

		if (!savedStudent.isPresent()) {
			throw new ResourceNotFoundException("No student found for given Id");
		}
		
		Project project = projectRepository.findById(studentInput.getProjectId()).get();

		Student savedStudentins = savedStudent.get();
		savedStudentins.setEmail(studentInput.getEmail());
		savedStudentins.setFullName(studentInput.getFullName());
		savedStudentins.setIndexNo(studentInput.getIndexNo());
		savedStudentins.setNic(studentInput.getNic());
		savedStudentins.setProject(project);
		savedStudentins.setRegNo(studentInput.getRegNo());
		savedStudentins.setSurname(studentInput.getSurname());
		savedStudentins.setTelephone(studentInput.getTelephone());
		
		return studentRepository.save(savedStudentins);
	}

}
