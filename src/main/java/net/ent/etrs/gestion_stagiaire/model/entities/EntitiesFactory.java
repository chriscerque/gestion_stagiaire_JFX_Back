package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.ent.etrs.gestion_stagiaire.commonUtils.ValidatorBean.ValidException;
import net.ent.etrs.gestion_stagiaire.commonUtils.ValidatorBean.ValidatorUtils;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;
import net.ent.etrs.gestion_stagiaire.model.entities.references.TypeIF;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EntitiesFactory {

    public static Stagiaire fabriquerStagiaire(String nom, String prenom, Grade grade) throws ValidException {
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setNom(nom);
        stagiaire.setPrenom(prenom);
        stagiaire.setGrade(grade);
        return ValidatorUtils.validate(stagiaire);
    }

    public static Stage fabriquerStage(String codeStage, LocalDate dateDebut, LocalDate dateFin, IngenierieFormation ingenierieFormation) throws ValidException{
        Stage stage = new Stage();
        stage.setCodeStage(codeStage);
        stage.setDateDebut(dateDebut);
        stage.setDateFin(dateFin);
        stage.setIngenierieFormation(ingenierieFormation);
        return ValidatorUtils.validate(stage);
    }

    public static Formateur fabriquerFormateur(String nom, String prenom, Grade grade) throws ValidException{
        Formateur formateur = new Formateur();
        formateur.setNom(nom);
        formateur.setPrenom(prenom);
        formateur.setGrade(grade);
        return ValidatorUtils.validate(formateur);
    }

    public static Note fabriquerNote(Double valeur, Evaluation evaluation, Formateur formateur, LocalDate dateNote) throws ValidException{
        Note note = new Note();
        note.setValeur(valeur);
        note.setEvaluation(evaluation);
        note.setFormateur(formateur);
        note.setDateNote(dateNote);
        return ValidatorUtils.validate(note);
    }

    public static Evaluation fabriquerEvaluation(Integer coeff, Matiere matiere, Appartenance typeStagiaire) throws ValidException{
        Evaluation evaluation = new Evaluation();
        evaluation.setCoeff(coeff);
        evaluation.setMatiere(matiere);
        evaluation.setTypeStagiaire(typeStagiaire);
        return ValidatorUtils.validate(evaluation);
    }

    public static Matiere fabriquerMatiere(String nom) throws ValidException{
        Matiere matiere = new Matiere();
        matiere.setNom(nom);
        return ValidatorUtils.validate(matiere);
    }

    public static IngenierieFormation fabriquerIngenierieFormation(String libelle, LocalDate dateDebut, LocalDate dateFin, TypeIF typeIF, Set<UniteValeur> uniteValeurSet) throws ValidException{
        IngenierieFormation ingenierieFormation = new IngenierieFormation();
        ingenierieFormation.setLibelle(libelle);
        ingenierieFormation.setDateDebut(dateDebut);
        ingenierieFormation.setDateFin(dateFin);
        ingenierieFormation.setTypeIF(typeIF);
        ingenierieFormation.setUvSet(uniteValeurSet);
        return ValidatorUtils.validate(ingenierieFormation);
    }

    public static UniteValeur fabriquerUniteValeur(Integer indice) throws ValidException{
        UniteValeur uniteValeur = new UniteValeur();
        uniteValeur.setIndice(indice);
        return ValidatorUtils.validate(uniteValeur);
    }

}
