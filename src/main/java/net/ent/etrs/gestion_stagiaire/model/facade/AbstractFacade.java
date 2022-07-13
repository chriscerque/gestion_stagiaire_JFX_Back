package net.ent.etrs.gestion_stagiaire.model.facade;

import net.ent.etrs.gestion_stagiaire.repo.FormateurRepo;
import net.ent.etrs.gestion_stagiaire.repo.StageRepo;
import net.ent.etrs.gestion_stagiaire.repo.StagiaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractFacade {

    @Autowired
    protected StageRepo stageRepo;
    @Autowired
    protected StagiaireRepo stagiaireRepo;
    @Autowired
    protected FormateurRepo formateurRepo;

    protected AbstractFacade() {

    }
}
