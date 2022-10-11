package net.ent.etrs.gestion_stagiaire.controller;

import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import net.ent.etrs.gestion_stagiaire.repo.StageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class StageController {

    @Autowired
    private StageRepo stageRepo;

    @GetMapping(produces = "application/json;charset=utf-8", path = "/stages")
    public List<Stage> getStages() {
        System.out.println("getStages");
        stageRepo.findAll().forEach(s -> System.out.printf("%s : %s | %s%n", s.getCodeStage(), s.getDateDebut(), s.getDateFin()));

        return stageRepo.findAll();
    }


}
