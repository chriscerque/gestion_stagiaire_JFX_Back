package net.ent.etrs.gestion_stagiaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@SpringBootApplication
public class GestionStagiaireApplication {

//	@PersistenceContext
//	private static EntityManager em1;

	public static void main(String[] args) {
		try {

//			Properties pros = System.getProperties();
//			pros.list(System.out);
//
//			Locale locale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
//			ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
//			System.out.println(resourceBundle.getString("hello"));


//			EntityManager em = Persistence.createEntityManagerFactory("PU_CREATE").createEntityManager();
		EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
//		System.out.println(">>>>>>>>>>>>>>>>>>> em1 : " + em1);
			System.out.println(">>>>>>>>>>>>>>>>>>> em : " + em);
			SpringApplication.run(GestionStagiaireApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
