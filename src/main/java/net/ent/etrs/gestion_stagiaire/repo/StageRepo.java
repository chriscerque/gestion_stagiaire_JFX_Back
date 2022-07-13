package net.ent.etrs.gestion_stagiaire.repo;

import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface StageRepo extends JpaRepository<Stage,Long> {

    Stage findByCodeStage(String codeStage);

}
