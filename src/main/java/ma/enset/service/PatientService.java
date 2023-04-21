package ma.enset.service;

import ma.enset.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    Patient ajouterPatient(Patient patient);
    Patient consulterPatient(Long id);
    List<Patient> consulterPatients();
    Page<Patient> consulterPatients(String key, int page, int size);
    Page<Patient> consulterPatients(int page, int size);
    Patient modifierPatient(Patient patient);
    void supprimerPatient(Long id);

}
