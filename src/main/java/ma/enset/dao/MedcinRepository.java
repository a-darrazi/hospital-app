package ma.enset.dao;

import ma.enset.model.Medcin;
import ma.enset.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository<Medcin, Long> {
}
