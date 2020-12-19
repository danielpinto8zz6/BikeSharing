package estg.mtsd.bikeshare.account.service.vo;

public class UserVo {

	private String email ;

	private String password ;

	private String id ;

	private String username ;

	private String photourl ;

	public UserVo(){
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