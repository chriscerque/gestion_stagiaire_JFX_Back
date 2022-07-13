package net.ent.etrs.gestion_stagiaire.commonUtils.ValidatorBean;

import javax.validation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Classe utilitaire contenant les méthodes de validation de bean sur la base du 
 * framework beanValidation (JSR-303).
 * @author christophe.louer
 *
 */public final class ValidatorUtils {

	/**
	 * Validator.
	 */
	private static final Validator VALIDATOR;

	static
	{
		VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/**
	 * Constructeur.
	 */
	private ValidatorUtils()
	{
	}


	/**
	 * Valide les contraintes de l'objet.
	 * Les erreurs sont embarquées dans le message de l'exception levée.
	 * @param objet objet à valider.
	 * @throws ValidationException exception levée si au moins une contrainte.
	 */
	public static void validateString(final Object objet) throws ValidationException
	{
		Set<ConstraintViolation<Object>> contraintesViolees =  VALIDATOR.validate(objet);
		if (!contraintesViolees.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			
			List<ConstraintViolation<Object>> contraintesVioleesTriees = new ArrayList<>(contraintesViolees) ;	
			
			Collections.sort(contraintesVioleesTriees, new ContraintesVioleesComparator());
			
			for (ConstraintViolation<Object> c : contraintesVioleesTriees) {
				sb.append(String.format("%s : %s%n",c.getPropertyPath(),c.getMessage()));
			}
			throw new ValidationException(sb.toString());
		}		
		
	}

	/**
	 * Valide les contraintes de l'objet.
	 * @param objet à contrôler.
	 * @return Un objet de type ErreurBean contenant une Map dont la clé 
	 * correspond au champ en erreur, et la valeur le libellé de l'erreur.
	 */
	public static ErreurBean validateErreurBean(final Object objet) 
	{
		ErreurBean erreurs = new ErreurBean();
		Set<ConstraintViolation<Object>> contraintesViolees =  VALIDATOR.validate(objet);
		if (!contraintesViolees.isEmpty()) {
			
			for (ConstraintViolation<Object> c : contraintesViolees) {
				erreurs.ajouterErreur(c.getPropertyPath().toString(), c.getMessage()); 
			}
		}		
		
		return erreurs;
	}

	public static <T> T validate(T o) throws ValidException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Object>> violations = validator.validate(o);
		if (violations.size() != 0) {
			throw new ValidException(violations);
		}
		return o;
	}
}
