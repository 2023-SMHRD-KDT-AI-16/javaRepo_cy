package model;

public class LoginDTO {

	private String id; // 회원 id
	private String pw; // 회원 비밀번호
	private String name; // 회원 이메일
	private String email; // 회원 닉네임

//	private int pic_num; // 영화사진 인덱스
//	private String pic_id; // 영화사진 이름
	//private String pic_hint; // 영화속 명대사
//	private String actor; // 출연 배우

	private int rank; // 랭킹

	// 생성자 - 오버로딩 중복정의
	public LoginDTO(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}
	
	public LoginDTO(String id,int rank) {
		this.id = id;
		this.rank = rank;
	}


	// Getter -> 매개변수는 없고, 리턴값만 있는 메소드.
	// Setter -> 매개변수만 있고, 리턴값은 없는 메소드.

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
