package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {

    @NonNull
    private String username;
    @NonNull
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;


}
