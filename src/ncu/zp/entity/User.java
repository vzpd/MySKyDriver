package ncu.zp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "system_users")
public class User {
	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "user_name", length = 50)
	private String userName;
	@Column(name = "user_passWord", length = 50)
	private String userPassword;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User() {

	}

}
