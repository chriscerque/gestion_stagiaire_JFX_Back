package net.ent.etrs.gestion_stagiaire.commonUtils.ValidatorBean;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Bean pouvant recevoir les erreurs de validation d'un autre bean.
 * @author christophe.louer
 *
 */
@SuppressWarnings("serial")
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
public class ErreurBean implements Serializable{
	/**
	 * Map contenant les éventuelles erreurs de validation des attributs.
	 * La clé correspond au nom de l'attribut, la valeur le message associé.
	 */
	@Getter @Setter
	Map<String, String> erreurs = new TreeMap<>();
	
	/**
	 * Permet l'ajout d'une erreur sur un attribut.
	 * @param champ attribut concerné par l'erreur.
	 * @param libelle libellé d'erreur correspondant.
	 */
	public void ajouterErreur(String champ,String libelle) {
		this.erreurs.put(champ, libelle);
	}

}
