package estg.mtsd.bikeshare.account.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Column(name="email")
	private String email ;

	@Column(name="password")
	private String password ;

	@Id
	@Column(name="id")
	private String id ;

	@Column(name="username")
	private String username ;

	@Column(name="photourl")
	private String photourl ;

	public User(){
		super();
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPhotourl(){
		return this.photourl;
	}

	public void setPhotourl(String photourl){
		this.photourl = photourl;
	}

}