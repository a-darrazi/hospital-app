package ma.enset.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.model.Patient;
import ma.enset.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String home(Model model,
                       @RequestParam(name="search",required = false, defaultValue = "") String search,
                       @RequestParam(name = "page",required = false, defaultValue = "1") int page,
                       @RequestParam(name="size",required = false, defaultValue = "5") int size){
        page = page > 0 ? --page:0;
        Page<Patient> patients = patientService.consulterPatients(search, page, size);
        model.addAttribute("patients", patients.stream().toList());
        model.addAttribute("search", search);
        model.addAttribute("totalPagesArr",new int[patients.getTotalPages()]);
        model.addAttribute("totalPages",patients.getTotalPages());
        model.addAttribute("currentPage",page);
        model.addAttribute("currentSize",size);
        model.addAttribute("isFirstPage",patients.isFirst());
        model.addAttribute("isLastPage",patients.isLast());
        return "index";
    }

    @GetMapping("/patient")
    public String getPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatient(Model model, @Valid Patient patient, BindingResult bindingResult){
        model.addAttribute("patient", patient);
        if(bindingResult.hasErrors()){
            return "addPatient";
        }
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
    public String updatePatient(@Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addPatient";
        }
        patientService.modifierPatient(patient);
        return "redirect:/home";
    }

    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable("id") Long id){
        patientService.supprimerPatient(id);
        return "redirect:/home";
    }




}
