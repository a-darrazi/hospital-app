package ma.enset.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="patients")
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", updatable = false, insertable = false)
    private Long id;
    @Column(name = "patient_nom", length = 50)
    private String nom;
    @Column(name = "patient_naissance")
    private Date dateNaissance;
    @Column(name = "isMalade")
    private boolean malade;
    @Column(name = "patient_score")
    private int score;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
