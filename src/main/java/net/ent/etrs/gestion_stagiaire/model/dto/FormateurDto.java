package net.ent.etrs.gestion_stagiaire.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.AbstractEntity;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;

import javax.persistence.*;


@ToString
public class FormateurDto extends AbstractEntity {

    public String nom;

    public String prenom;

    public Grade grade;

}
