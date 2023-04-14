package ma.enset.service;

import ma.enset.model.Consultation;
import ma.enset.model.Medcin;
import ma.enset.model.Patient;
import ma.enset.model.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medcin saveMedcin(Medcin medcin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
