package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// Connect 메소드
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String user = "mp_21K_bigdata22_p1_4";
			String pw = "smhrd4";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";

			conn = DriverManager.getConnection(url, user, pw);
			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	// close 하는 메소드
	private void allClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// delete기능 메소드
	public int deleteMember(String delete_id) {
		getConn();
		try {
			// sql통과 통로
			String sql = "delete from member where id = ?";
			psmt = conn.prepareStatement(sql);

			// ?채우기 - ?가 없으면 생략
			psmt.setString(1, delete_id);
			// sql통과 하세요!
			int row = psmt.executeUpdate();
			return row;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			allClose();

		}

	}

	// update기능 메소드
	public int updateMember(String update_pw, String update_id) {
		getConn();
		try {

			// sql통과 통로
			String sql = "update member set pw = ? where id = ?";
			psmt = conn.prepareStatement(sql);

			// ?채우기 - ?가 없으면 생략
			psmt.setString(1, update_pw);
			psmt.setString(2, update_id);

			// sql통과 하세요!
			int row = psmt.executeUpdate();
			return row;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			allClose();

		}

	}

	// insert기능 메소드
	public int insertMember(LoginDTO ldto) {
		getConn();
		try {

			// sql통과 통로
			String sql = "insert into member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			// ?채우기 - ?가 없으면 생략
			psmt.setString(1, ldto.getId());
			psmt.setString(2, ldto.getPw());
			psmt.setString(3, ldto.getName());
			psmt.setString(4, ldto.getEmail());

			// sql통과 하세요!
			int row = psmt.executeUpdate();
			return row;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			allClose();
		}
	}

	// 로그인 메소드
	public Boolean loginInfo(String id, String pw) {
		// 로그인 검사하는 메소드 loginInfo

		String dbID = null;
		String dbPW = null;

		getConn();
		try {
			// sql통과 통로
			String sql = "select ID,PW from member where ID = ?";
			psmt = conn.prepareStatement(sql);

			// ?채우기 - ?가 없으면 생략

			psmt.setString(1, id);

			// sql통과 하세요!
			rs = psmt.executeQuery();

			// select 한줄의 데이터 확인 rs.next()
			while (rs.next()) {
				dbID = rs.getString(1);
				dbPW = rs.getString(2);
			}
			if (dbID.equals(id) && dbPW.equals(pw)) { // 아이디 비번 일치
				System.out.println("아이디 비번 일치");
				return true;
			} else {
				System.out.println("아이디 비번 불일치");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			allClose();
		}
		return false;
	}

	// 랭킹 순위 메소드(숙제)
	public ArrayList<LoginDTO> showRank() {
		ArrayList<LoginDTO> dtoList = new ArrayList<LoginDTO>();

		getConn();
		try {
			// sql통과 통로
			String sql = "select * from ranking order by rank desc"; // 전송할 쿼리문
			psmt = conn.prepareStatement(sql); // 쿼리문 전송 준비

			// ?채우기 - ?가 없으면 생략

			// sql통과 하세요!
			rs = psmt.executeQuery(); // 쿼리문 전송하고 실행

			// select 한줄의 데이터 확인 rs.next()
			while (rs.next()) {
				String id2 = rs.getString(1);
				int rank = rs.getInt(2);
				// System.out.println(rank);
				LoginDTO ldto = new LoginDTO(id2,rank);
				dtoList.add(ldto);
				// System.out.println(dtoList);
			}

			return dtoList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			allClose();
		}

	}
}
