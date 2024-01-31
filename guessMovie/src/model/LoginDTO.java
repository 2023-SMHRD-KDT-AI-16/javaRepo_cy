package model;

public class LoginDTO {

	private String id; // 회원 id
	private String pw; // 회원 비밀번호
	private String email; // 회원 이메일
	private String name; // 회원 닉네임

	public LoginDTO(String id, String pw, String email, String name) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
