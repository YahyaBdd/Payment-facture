package JPA;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	public Client(int id,String nom, String prenom,  String mail, String mdp, int montant,  String num) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.montant = montant;
		this.nom = nom;
		this.num = num;
		this.prenom = prenom;
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String mail;

	private String mdp;

	private int montant;

	private String nom;

	private String num;

	private String prenom;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}