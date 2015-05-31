package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Skill
 *
 */
@Entity
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String description;

	private List<Qualification> qualifications;
	private List<RequiredLevel> requiredLevels;

	public Skill() {
		super();
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "skill")
	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	@OneToMany(mappedBy = "skill")
	public List<RequiredLevel> getRequiredLevels() {
		return requiredLevels;
	}

	public void setRequiredLevels(List<RequiredLevel> requiredLevels) {
		this.requiredLevels = requiredLevels;
	}

}
