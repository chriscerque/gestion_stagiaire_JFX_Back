package net.ent.etrs.gestion_stagiaire.controller;

import net.ent.etrs.gestion_stagiaire.config.JwtTokenUtil;
import net.ent.etrs.gestion_stagiaire.model.JwtRequest;
import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import net.ent.etrs.gestion_stagiaire.model.entities.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("JwtAuthenticationController / createAuthenticationToken");
		System.out.println("authenticationRequest.getUsername() : " + authenticationRequest.getUsername());
		System.out.println("authenticationRequest.getPassword() : " + authenticationRequest.getPassword());

		try {
			this.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

			System.out.println("JwtAuthenticationController / createAuthenticationToken 2");
			System.out.println("SecurityContextHolder.getContext().getAuthentication().getPrincipal() : " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
			System.out.println("userDetails : " + userDetails);
			System.out.println("JwtAuthenticationController / createAuthenticationToken 3");
			final String token = jwtTokenUtil.generateToken(userDetails);
			System.out.println("JwtAuthenticationController / createAuthenticationToken 4");
//			return ResponseEntity.ok(new JwtResponse(token));
			MyUser myUser = new MyUser();
			myUser.setUsername(userDetails.getUsername());
//			return ResponseEntity.ok().header("Authorization",token).body(myUser);
			HttpHeaders responseHeaders = new HttpHeaders();
//			responseHeaders.setLocation(location);
			responseHeaders.set("Authorization", token);
			return new ResponseEntity<MyUser>(myUser, responseHeaders, HttpStatus.OK);
		}catch (UsernameNotFoundException e){
			e.printStackTrace();
			throw new Exception(e);
		}
		catch (Exception e1){
			e1.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		System.out.println("JwtAuthenticationController / saveUser");
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			System.out.println("JwtAuthenticationController / authenticate");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			e.printStackTrace();
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
