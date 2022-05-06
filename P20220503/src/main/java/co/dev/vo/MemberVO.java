package co.dev.vo;

public class MemberVO {
    private String id;
    private String name;
    private String passwd;
    private String email;
    private String profile;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    
    @Override
    public String toString() {
	return "MemberVO [id=" + id + ", name=" + name + ", passwd=" + passwd + ", email=" + email + ", profile="
		+ profile + "]";
    }
    
    
}
