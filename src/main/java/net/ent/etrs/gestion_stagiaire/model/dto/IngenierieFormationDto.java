package net.ent.etrs.gestion_stagiaire.model.dto;

import lombok.Getter;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.AbstractEntity;
import net.ent.etrs.gestion_stagiaire.model.entities.references.TypeIF;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IngenierieFormationDto extends AbstractEntity {

    public String libelle;

    public TypeIF typeIF;

    public LocalDate dateDebut;

    public LocalDate dateFin;

    Set<UniteValeurDto> uvSet = new HashSet<>();

    public void setUvSet(Set<UniteValeurDto> uvSet) {
        this.uvSet = uvSet;
    }

    public Set<UniteValeurDto> getUvSet() {
        return Collections.unmodifiableSet(this.uvSet);
    }
}
