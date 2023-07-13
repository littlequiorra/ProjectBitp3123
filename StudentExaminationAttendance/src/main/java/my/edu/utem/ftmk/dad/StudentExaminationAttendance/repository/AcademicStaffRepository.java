package my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.AcademicStaff;

@Repository
public interface AcademicStaffRepository extends JpaRepository<AcademicStaff, Long> {

}
