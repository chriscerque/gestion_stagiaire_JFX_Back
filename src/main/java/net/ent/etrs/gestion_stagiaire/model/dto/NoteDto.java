package net.ent.etrs.gestion_stagiaire.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.AbstractEntity;

import java.time.LocalDate;

@ToString
public class NoteDto extends AbstractEntity {

    public EvaluationDto evaluation;

    public Double valeur;

    public FormateurDto formateur;

    public LocalDate dateNote;

}
