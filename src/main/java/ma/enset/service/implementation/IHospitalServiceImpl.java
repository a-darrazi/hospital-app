package ma.enset.service.implementation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.enset.dao.ConsultationRepository;
import ma.enset.dao.MedcinRepository;
import ma.enset.dao.PatientRepository;
import ma.enset.dao.RendezVousRepository;
import ma.enset.model.Consultation;
import ma.enset.model.Medcin;
import ma.enset.model.Patient;
import ma.enset.model.RendezVous;
import ma.enset.service.IHospitalService;
import ma.enset.service.PatientService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class IHospitalServiceImpl implements IHospitalService {
    private final MedcinRepository medcinRepository;
    private final RendezVousRepository rendezVousRepository;
    private final ConsultationRepository consultationRepository;
    private final PatientService patientService;

    @Override
    public Patient savePatient(Patient patient) {
        return patientService.ajouterPatient(patient);
    }

    @Override
    public Medcin saveMedcin(Medcin medcin) {
        return medcinRepository.save(medcin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
