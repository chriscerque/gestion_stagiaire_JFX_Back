package net.ent.etrs.gestion_stagiaire;

import net.ent.etrs.gestion_stagiaire.controller.MyUserDetailService;
import net.ent.etrs.gestion_stagiaire.model.entities.Formateur;
import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Role;
import net.ent.etrs.gestion_stagiaire.model.facade.IStageFacade;
import net.ent.etrs.gestion_stagiaire.repo.FormateurRepo;
import net.ent.etrs.gestion_stagiaire.repo.StagiaireRepo;
import net.ent.etrs.gestion_stagiaire.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StagiaireRepo stagiaireRepo;

    //    @Autowired
//    public StageRepo stageRepo;
    @Autowired
    public IStageFacade iStageFacade;

    @Autowired
    public FormateurRepo formateurRepo;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Value("${toto.var}")
    private String text;

//    @Autowired
//    public UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.text);



        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>runner 0");
            MyUser user = new MyUser();
            user.setUsername("dark.vador@space.com");
            user.setPassword("aaaa");
            user.grantAuthority(Role.USER);

            UsernamePasswordAuthenticationToken authReq
                    = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication auth = authenticationProvider.authenticate(authReq);
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);

//        user.setPassword(passwordEncoder.encode("password"));
//        user.grantAuthority(Role.ROLE_ADMIN);
            System.out.println("userRepo.findUserByUsername(user.getUsername()) : " + userRepo.findUserByUsername(user.getUsername()));
            if(userRepo.findUserByUsername(user.getUsername()).isEmpty()) {
                System.out.println("save du user : " + user.getUsername());
                userRepo.save(user);
            }
//            System.out.println("qqqqqqqqq");
            System.out.println("userRepo.findUserByUsername(user.getUsername()).get() " + userRepo.findUserByUsername(user.getUsername()).get());
//            userRepo.save(user);
//            System.out.println("qqqqqqqqq22222222222222222");
//            SecurityProperties.User user2 = new SecurityProperties.User();
//            user.setUsername("DUPOND");
//            user.setPassword("titi");
//            userRepo.save(user2);


            System.out.println(">>>>>>>>>>>>>>>>>>>runner 1");
            Stagiaire stagiaire = new Stagiaire();
            stagiaire.setNom("toto9");
            stagiaire.setPrenom("totop9");
            stagiaire.setGrade(Grade.ADJ);
            stagiaire.setAppartenance(Appartenance.TERRE);
            System.out.println(">>>>>>>>>>>>>>>>>>>runner 2");
//            titi();
            System.out.println(">>>>>>>>>>>>>>>>>>>runner 3");
            stagiaireRepo.save(stagiaire);
            System.out.println(">>>>>>>>>>>>>>>>>>>runner 4");
            Stage stage = new Stage();

            stage.setCodeStage("CG91");
            stage.setDateDebut(LocalDate.now().minusDays(1));
            stage.setDateFin(LocalDate.now().plusDays(30));
            stage.addStagiaire(stagiaire);
            Formateur formateur = new Formateur();
            formateur.setNom("TOTO");
            formateur.setPrenom("toto p");
            formateur.setGrade(Grade.ADJ);
            formateurRepo.save(formateur);
            stage.setCdsf(formateur);
//            stageRepo.save(stage);
            System.out.println("recherche stage CG91" + iStageFacade.readStage("CG91"));

            iStageFacade.saveStage(stage);

            Stage stage2 = new Stage();
            stage2.setCodeStage("GJ50");
            stage2.setDateDebut(LocalDate.now().minusDays(1));
            stage2.setDateFin(LocalDate.now().plusDays(30));
            stage2.addStagiaire(stagiaire);
            Formateur formateur2 = new Formateur();
            formateur2.setNom("TOTO2");
            formateur2.setPrenom("toto2 p");
            formateur2.setGrade(Grade.MAJ);
            formateurRepo.save(formateur2);
            stage2.setCdsf(formateur2);
//            stageRepo.save(stage);
            System.out.println("recherche stage GJ50" + iStageFacade.readStage("GJ50"));

            iStageFacade.saveStage(stage2);



//        stageRepo.saveAndFlush(stage);
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    private void titi() {
        System.out.println("### getUsernameOfAuthenticatedUser");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("authentication.getPrincipal()).getUsername() " + ((MyUser) authentication.getPrincipal()).getUsername());
    }
}
