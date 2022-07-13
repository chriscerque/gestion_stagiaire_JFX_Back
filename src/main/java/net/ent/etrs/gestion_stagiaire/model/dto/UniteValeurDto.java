package net.ent.etrs.gestion_stagiaire.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.AbstractEntity;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@ToString
public class UniteValeurDto extends AbstractEntity {

    private Integer indice;


    Set<EvaluationDto> evaluationList = new HashSet<>();

    public void ajouterEvaluation(EvaluationDto evaluation){
        this.evaluationList.add(evaluation);
    }

    public void supprimerEvaluation(EvaluationDto evaluation){
        this.evaluationList.remove(evaluation);
    }


}
