package net.ent.etrs.gestion_stagiaire.secu;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"net.ent.etrs.gestion_stagiaire.repo"})
@EntityScan(basePackages = {"net.ent.etrs.gestion_stagiaire.model", "net.ent.etrs.gestion_stagiaire.model.references"})
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersistenceConfig {
    @Bean
    AuditorAware<String> auditorProvider() {
        System.out.println(">>>>>>>>PersistenceConfig/auditorProvider");
        return new AuditorAwareImpl();
    }

    @Bean
    public AccessDeniedHandler getAccessDeniedHandler() {
        return new AccessDeniedHandlerImpl();
    }

}
