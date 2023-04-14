package ma.enset.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.model.Patient;
import ma.enset.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model){
        List<Patient> patients = patientService.consulterPatients();
        model.addAttribute("patients", patients);
        return "index";
    }

    @GetMapping("/patient")
    public String getPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatient(Model model,Patient patient){
        model.addAttribute("patient", new Patient());
        patientService.ajouterPatient(patient);
        return "redirect:/home";
    }

    @GetMapping("/patient/{id}")
    public String getPatient(Model model,@PathVariable("id") Long id){
        Patient patient = patientService.consulterPatient(id);
        model.addAttribute("patient", patient);
        return "updatePatient";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(Patient patient){
        patientService.modifierPatient(patient);
        return "redirect:/home";
    }

    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable("id") Long id){
        patientService.supprimerPatient(id);
        return "redirect:/home";
    }




}
