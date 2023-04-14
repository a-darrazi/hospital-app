package ma.enset.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private StatusRDV statusRDV;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medcin medcin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}