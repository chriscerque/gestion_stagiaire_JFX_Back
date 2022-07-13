package net.ent.etrs.gestion_stagiaire.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.AbstractEntity;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@ToString
public class MatiereDto extends AbstractEntity {

    public String nom;

}
