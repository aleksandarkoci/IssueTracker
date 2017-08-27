package issue.tracker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue
	@Column (name="ID")
	private Integer id;
	
	@Column (name="USERNAME")
	private String username;
	
	@Column (name="PASSWORD")
	private String password;
	
	@Column (name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Bug> bugList = new ArrayList<>();

	public User() {}

	public User(String username, String password, String email, List<Bug> bugList) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.bugList = bugList;
	}

	public User(Integer id, String username, String password, String email, List<Bug> bugList) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.bugList = bugList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Bug> getBugList() {
		return bugList;
	}

	public void setBugList(List<Bug> bugList) {
		this.bugList = bugList;
	}
	
	
}
