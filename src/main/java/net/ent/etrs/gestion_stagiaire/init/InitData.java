package net.ent.etrs.gestion_stagiaire.init;


import net.ent.etrs.gestion_stagiaire.controller.MyUserDetailService;
import net.ent.etrs.gestion_stagiaire.model.dto.DtoUtils;
import net.ent.etrs.gestion_stagiaire.model.dto.StagiaireDto;
import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.model.entities.UserDTO;
import net.ent.etrs.gestion_stagiaire.repo.StagiaireRepo;
import net.ent.etrs.gestion_stagiaire.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class InitData implements ApplicationRunner {

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private StagiaireRepo stagiaireRepo;

    @Autowired
    public InitData(MyUserDetailService userDetailsService, StagiaireRepo stagiaireRepo) {
        this.userDetailsService = userDetailsService;
        this.stagiaireRepo = stagiaireRepo;
    }

    public void run(ApplicationArguments args) {
        userDetailsService.save(new UserDTO("ADMIN","ADMIN"));
        userDetailsService.save(new UserDTO("ADMIN2","ADMIN2"));
        userDetailsService.save(new UserDTO("ADMIN3","ADMIN3"));
        userDetailsService.save(new UserDTO("ADMIN4","ADMIN4"));

        StagiaireDto stagiaireDto = new StagiaireDto();
        stagiaireDto.nid = "0123456789";
        stagiaireDto.nom = "0123456789";
        stagiaireDto.prenom = "0123456789";
        stagiaireDto.dateNaissance = LocalDate.now().minusYears(18);
        stagiaireDto.matricule = "0337010562";
        stagiaireRepo.save(DtoUtils.stagiaireFromDto(stagiaireDto));
    }
}
