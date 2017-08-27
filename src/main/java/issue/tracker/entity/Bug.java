package issue.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Bug {

	@Id
	@GeneratedValue
	@Column (name="ID")
	private Integer id;
	
	@Column (name="BUGNAME")
	private String bugName;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;

	public Bug() {}

	public Bug(String bugName, User user) {
		this.bugName = bugName;
		this.user = user;
	}

	public Bug(Integer id, String bugName, User user) {
		this.id = id;
		this.bugName = bugName;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
