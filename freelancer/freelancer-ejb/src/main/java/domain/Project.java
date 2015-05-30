package domain;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	
	private Integer id;
	private String Titre;
	private String Description;
	private Boolean ouvert;
	private Date dateDepot;
	private Date dateFermeture;
	private static final long serialVersionUID = 1L;

	public Project() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getTitre() {
		return this.Titre;
	}

	public void setTitre(String Titre) {
		this.Titre = Titre;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public Boolean getOuvert() {
		return this.ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}   
	public Date getDateDepot() {
		return this.dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}   
	public Date getDateFermeture() {
		return this.dateFermeture;
	}

	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}
   
}
