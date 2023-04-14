package ma.enset.dao;

import ma.enset.model.Patient;
import ma.enset.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
