package net.ent.etrs.gestion_stagiaire.secu;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppAuthProvider extends DaoAuthenticationProvider {
//    @Autowired
//    UserDetailsService userDetailsService;
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        System.out.println(">>>>>>>>AppAuthProvider/authenticate");
//        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
//        System.out.println("auth : " + auth);
//        System.out.println("auth;getName() : " + auth.getName());
//        String name = auth.getName();
//        String password = auth.getCredentials()
//                .toString();
//
//        UserDetails user = userDetailsService.loadUserByUsername(name);
//
//        System.out.println(">>>>>>>>UserDetails : " + user);
//        if (user == null) {
//            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
//        }
//        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
//
//    }
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
}
