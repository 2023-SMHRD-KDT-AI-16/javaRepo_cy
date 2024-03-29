package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseDAO {
	// DB 관련된 메소드 모음

	private static Connection conn;
	private static PreparedStatement psmt;
	private static ResultSet rs;

	// Connect 메소드 - 민중님 작성
	public static void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String user = "mp_21K_bigdata22_p1_4";
			String pw = "smhrd4";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";

			conn = DriverManager.getConnection(url, user, pw);
			if (conn != null) {
			} else {
				System.out.println("Database 연결 실패 ㅠ");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	// close 하는 메소드 - 민중님 작성
	private static void allClose() {
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

//	// delete기능 메소드 - 민중님 작성
//	public int deleteMember(String delete_id) {
//		getConn();
//		try {
//			// sql통과 통로
//			String sql = "delete from member where id = ?";
//			psmt = conn.prepareStatement(sql);
//
//			// ?채우기 - ?가 없으면 생략
//			psmt.setString(1, delete_id);
//			// sql통과 하세요!
//			int row = psmt.executeUpdate();
//			return row;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return 0;
//		} finally {
//			allClose();
//
//		}
//
//	}
	
	
	// select기능 메소드
		public ArrayList<LoginDTO> selectRanking() {
			ArrayList<LoginDTO> dtoList = new ArrayList<LoginDTO>();

			getConn();
			try {
				// sql통과 통로
				String sql = "select * from ranking order by rank desc";
				psmt = conn.prepareStatement(sql);

				// ?채우기 - ?가 없으면 생략

				// sql통과 하세요!
				rs = psmt.executeQuery();

				// select 한줄의 데이터 확인 rs.next()
				while (rs.next()) {
					String id = rs.getString(1);
					int Ranking = rs.getInt(2);

					LoginDTO ldto = new LoginDTO(id, Ranking);
					dtoList.add(ldto);
				}

				return dtoList;

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				allClose();
			}
		}

	// update기능 메소드 - 민중님 작성, 채영 수정 -> ranking 정보 업데이트
	public int updateRanking(int update_rank, String update_id) {
		
		getConn();
		
		try {
			
			 conn.setAutoCommit(false);

			// sql통과 통로
			String sql = "update ranking set rank = ? + rank where id = ?";
			psmt = conn.prepareStatement(sql);

			// ?채우기 - ?가 없으면 생략
			psmt.setInt(1, update_rank);
			psmt.setString(2, update_id);

			// sql통과 하세요!
			int row = psmt.executeUpdate();
			
			conn.commit();
			
			return row;
			

		} catch (SQLException e) {
			try {
				conn.rollback(); // 오류 발생하면 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return 0;
		} finally {
			allClose();

		}

	}


	// insert기능 메소드 - 민중님 작성
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

	public int insertRank(String input_id) { // 랭킹 정보 최초 생성
		getConn();
		try {

			// sql통과 통로
			String sql = "insert into ranking values(?,?)";
			psmt = conn.prepareStatement(sql);

			// ?채우기 - ?가 없으면 생략
			psmt.setString(1, input_id);
			psmt.setInt(2, 0);

			// sql통과 하세요!
			int row = psmt.executeUpdate();
			
			conn.commit();
			
			return row;

		} catch (SQLException e) {
			try {
				conn.rollback(); // 오류 발생하면 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return 0;
		} finally {
			allClose();
		}
	}
	
	
	public static Boolean loginInfo(String id, String pw){
		// 로그인 검사하는 메소드 loginInfo
		
		String dbID = null;
		String dbPW = null;
		
		getConn();
		try {
			// sql통과 통로
			String sql = "select ID,PW from member where ID = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			// ?채우기 - ?가 없으면 생략

			// sql통과 하세요!
			rs = psmt.executeQuery();

			// select 한줄의 데이터 확인 rs.next()
			while (rs.next()) {
				dbID = rs.getString(1);
				dbPW = rs.getString(2);
				if(dbID != null || dbPW != null) { // 비어있지 않다 -> 회원이다
					if(dbID.equals(id)&&dbPW.equals(pw)) { // 아이디 비번 일치
						System.out.println("아이디 비번 일치");
						return true;
					}else { // 
						System.out.println("아이디 비번 불일치");
						return false;
					}
				}else {
					// 비어있다 -> 등록되어 있지 않다
					System.out.println("회원이 아닙니다");
					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			allClose();
		}
		return false;
	}
	
	public static Boolean signUp(String join_id) {
		// 회원가입 id 중복 검사하는 메소드 signUp
		
		getConn();
		
		String dbID = null;
		try {
			
			String sql = "select ID from member where ID = ?";
			psmt = conn.prepareStatement(sql);
		
			psmt.setString(1, join_id);
		
			// ?채우기 - ?가 없으면 생략

			// sql통과 하세요!
			rs = psmt.executeQuery();

			// select 한줄의 데이터 확인 rs.next()
			
			while (rs.next()) { // 데이터 한줄 가져오기
				dbID = rs.getString(1);
				if(dbID.equals(join_id)) { // 같다면 -> 아이디 존재
					return false;
				}else { // 
					return true; // 다르다면 -> 아이디 없음
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			allClose();
		}
	return false;
	}
	
}
