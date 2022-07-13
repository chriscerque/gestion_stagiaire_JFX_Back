package net.ent.etrs.gestion_stagiaire.model.facade;

import net.ent.etrs.gestion_stagiaire.model.dto.StagiaireDto;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;

import java.util.List;

public interface IStagiaireFacade {

    Stagiaire saveStagiaire(Stagiaire stagiaire);
    void deleteStagiaire(Stagiaire stagiaire);
    Stagiaire readStagiaire(Long id);
    List<Stagiaire> readAllStagiaire();
    Stagiaire readStage(String nom, String prenom);


}
