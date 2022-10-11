package net.ent.etrs.gestion_stagiaire.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "STAGIAIRE")
@ToString(exclude = "noteList")
public class Stagiaire extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "NOM", nullable = false)
    @NotBlank(message = Cmodel.BV_STAGIAIRE_NOM_NOT_NULL)
    @JsonProperty("name")
    private String nom;

    @Getter
    @Setter
    @Column(name = "PRENOM", nullable = false)
    @NotBlank(message = Cmodel.BV_STAGIAIRE_PRENOM_NOT_NULL)
    private String prenom;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "GRADE", nullable = false)
    @NotNull(message = Cmodel.BV_STAGIAIRE_GRADE_NOT_NULL)
    private Grade grade;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "APPARTENANCE", nullable = false)
//    @NotNull(message = Cmodel.BV_STAGIAIRE_APPARTENANCE_NOT_NULL)
    @JsonIgnore
    private Appartenance appartenance;

    @Getter
    @Setter
//    @NotNull(message = Cmodel.BV_STAGIAIRE_DATE_NAISSANCE_NOT_NULL)
    @Past(message = Cmodel.BV_STAGIAIRE_DATE_NAISSANCE_PAST)
    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;

    @Getter
    @Setter
    @Pattern(regexp = Cmodel.STAGIAIRE_PATTERN_MATRICULE)
    @Column(name = "MATRICULE")
    private String matricule;

    @Getter
    @Setter
    @Pattern(regexp = Cmodel.STAGIAIRE_PATTERN_NID)
    @Column(name = "NID")
    private String nid;

    @Getter
    @Setter
    @Column(name = "NUM_BATIEMENT")
    private Integer numBatiment;

    @Getter
    @Setter
    @Column(name = "NUM_CHAMBRE")
    private Integer numChambre;

    @Getter
    @Setter
    @Column(name = "NUM_BADGE_MESS")
    private Integer numBadgeMess;

    @Getter
    @Setter
    @Column(name = "NUM_BADGE_ACCES")
    private Integer numBadgeAcces;

//    public Set<Note> getNoteList() {
//        return Collections.unmodifiableSet(this.noteList);
//    }
//
//    @OneToMany
//    @JoinColumn(name = "STAGIAIRE_ID", foreignKey = @ForeignKey(name = "FK_NOTE_STAGIAIRE_ID"))
//    private Set<Note> noteList = new HashSet<>();
//
//    public void ajouterNote(@Valid Note note) {
//        this.noteList.add(note);
//    }
//
//    public void supprimerNote(@Valid Note note) {
//        this.noteList.remove(note);
//    }


}
