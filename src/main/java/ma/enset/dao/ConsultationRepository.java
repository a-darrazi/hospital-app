package ma.enset.dao;

import ma.enset.model.Consultation;
import ma.enset.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
