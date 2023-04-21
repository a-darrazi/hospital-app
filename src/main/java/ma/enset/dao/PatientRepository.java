package ma.enset.dao;

import ma.enset.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("FROM Patient p where p.nom like %:name%")
    Page<Patient> findByName(@Param("name") String name, Pageable pageable);
}
