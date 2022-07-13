package net.ent.etrs.gestion_stagiaire.model.dto;

import lombok.*;
import net.ent.etrs.gestion_stagiaire.model.entities.AbstractEntity;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ToString
public class EvaluationDto extends AbstractEntity {

    public Integer coeff;

    public Appartenance typeStagiaire;

    public MatiereDto matiere;
}
