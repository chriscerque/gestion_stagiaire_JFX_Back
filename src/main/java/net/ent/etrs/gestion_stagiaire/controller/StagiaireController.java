package net.ent.etrs.gestion_stagiaire.controller;

import net.ent.etrs.gestion_stagiaire.model.dto.DtoUtils;
import net.ent.etrs.gestion_stagiaire.model.dto.StagiaireDto;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.model.facade.IStagiaireFacade;
import net.ent.etrs.gestion_stagiaire.repo.StagiaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class StagiaireController {

    @Autowired
    private StagiaireRepo stagiaireRepo;

    @Autowired
    private IStagiaireFacade stagiaireFacade;


    @GetMapping(produces = "application/json;charset=utf-8", path = "/stagiaires")
    public List<Stagiaire> getStagiaire() {

        stagiaireRepo.findAll().forEach(s -> System.out.printf("%s : %s | %s%n", s.getNom(), s.getPrenom(), s.getAppartenance()));

        return stagiaireRepo.findAll();
    }

    @PostMapping(produces = "application/json;charset=utf-8", path = "/Stagiaire")
    public ResponseEntity<?> setStagiaire(@RequestBody StagiaireDto stagiaireDto) {
        System.out.println("StagiaireController / setStagiaire");
        System.out.println("stagiaire : " + stagiaireDto);


        return ResponseEntity.ok(stagiaireRepo.save(DtoUtils.stagiaireFromDto(stagiaireDto)));
    }

}
