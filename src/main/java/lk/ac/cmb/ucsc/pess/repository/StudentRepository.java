package lk.ac.cmb.ucsc.pess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ac.cmb.ucsc.pess.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
