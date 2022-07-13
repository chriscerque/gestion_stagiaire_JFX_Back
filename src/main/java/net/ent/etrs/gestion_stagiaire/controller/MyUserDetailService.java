package net.ent.etrs.gestion_stagiaire.controller;

import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import net.ent.etrs.gestion_stagiaire.model.entities.UserDTO;
import net.ent.etrs.gestion_stagiaire.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public MyUser loadUserByUsername(String username) {
        System.out.println(">>>>>>>>>>MyUserDetailService/loadUserByUsername");

        try {
            MyUser user = userRepo.findUserByUsername(username).orElseThrow(() ->new NonUniqueResultException("tutututututu"));
            System.out.println("user : " + user);
//            if (user == null) {
//                throw new UsernameNotFoundException("User not found with username: " + username);
//            }
//            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                    new ArrayList<>());
            return user;
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        } catch (NonUniqueResultException e) {
            e.printStackTrace();
            throw new NonUniqueResultException(e.getMessage());
        }

//        try {
//
//            System.out.println("username : " + username);
//            Objects.requireNonNull(username);
//            UserDetails user = userRepo.findUserByUsername(username)
//                    .orElseThrow(() -> new UsernameNotFoundException(String.format("Username[%s] not found",username)));
//
//            System.out.println("user : " + user);
//            return user;
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }
//        System.out.println("return nullllllllllll");
//        return null;
    }

    public MyUser save(UserDTO userDTO) {
        MyUser newUser = new MyUser();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        try {
            return this.loadUserByUsername(newUser.getUsername());
        }catch (UsernameNotFoundException | NonUniqueResultException e){
            return userRepo.save(newUser);
        }


    }

//    private List<GrantedAuthority> getGrantedAuthorities(MyUser user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        List<Role> roles = user.getRoles();
//        roles.forEach(r->authorities.add(new SimpleGrantedAuthority(r.toString())));
////        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        return authorities;
//    }
}
