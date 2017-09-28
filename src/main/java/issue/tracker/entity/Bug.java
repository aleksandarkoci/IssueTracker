package issue.tracker.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bug {

	@Id
	@GeneratedValue
	@Column (name="BUG_ID")
	private Integer id;
	
	@Column (name="BUGNAME")
	private String bugName;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	public Bug() {}

	public Bug(String bugName) {
		this.bugName = bugName;
	}

	public Bug(Integer id, String bugName) {
		this.id = id;
		this.bugName = bugName;
	}
	
	public Bug(Integer id, String bugName, Date dateCreated) {
		super();
		this.id = id;
		this.bugName = bugName;
		this.dateCreated = dateCreated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
