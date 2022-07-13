package net.ent.etrs.gestion_stagiaire.model.facade;

import net.ent.etrs.gestion_stagiaire.model.entities.Stage;

import java.util.List;
import java.util.Optional;


public interface IStageFacade {

    Stage saveStage(Stage stage);
    void deleteStage(Stage stage);
    Optional<Stage> readStage(Long id);
    List<Stage> readAllStage();
    Stage readStage(String codeStage);
}
