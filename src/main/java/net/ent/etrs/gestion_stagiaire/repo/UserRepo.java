package net.ent.etrs.gestion_stagiaire.repo;

import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<MyUser, Long> {

    @Query("select u from MyUser u where u.username = :userName")
    Optional<MyUser> findUserByUsername(@Param("userName") String username);
}
