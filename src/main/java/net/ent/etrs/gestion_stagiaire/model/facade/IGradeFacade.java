package net.ent.etrs.gestion_stagiaire.model.facade;

import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;

import java.util.List;


public interface IGradeFacade {
    List<Grade> readAllGrades();
}
