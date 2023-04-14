package ma.enset.service.implementation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.enset.dao.PatientRepository;
import ma.enset.model.Patient;
import ma.enset.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public Patient ajouterPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient consulterPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ce patient n'existe pas")
        );
    }

    @Override
    public List<Patient> consulterPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> consulterPatient(int page, int size) {
        return patientRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Patient modifierPatient(Patient patient) {
        consulterPatient(patient.getId());
        return patientRepository.save(patient);
    }

    @Override
    public void supprimerPatient(Long id) {
        patientRepository.deleteById(id);
    }
}
