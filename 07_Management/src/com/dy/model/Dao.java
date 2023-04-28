package com.dy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dy.vo.Product;


public class Dao {

	// 전체 조회
	public ArrayList<Product> selectList(Connection conn) {
		ArrayList<Product> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM PRODUCT";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DBADMIN", "java1234");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Product p1 = new Product();

				p1.setId(rset.getString("product_id"));
				p1.setName(rset.getString("p_name"));
				p1.setPrice(rset.getInt("price"));
				p1.setDescription(rset.getString("DESCRIPTION"));
				p1.setStock(rset.getInt("stock"));

				list.add(p1);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	
	public Product selectByUserId(Connection conn, String Id) {
		Product p1 = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM PRODUCT WHERE product_id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DBADMIN", "java1234");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Id);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				p1 = new Product();

				p1.setId(rset.getString("PRODUCT_ID"));
				p1.setName(rset.getString("P_NAME"));
				p1.setPrice(rset.getInt("PRICE"));
				p1.setDescription(rset.getString("DESCRIPTION"));
				p1.setStock(rset.getInt("STOCK"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return p1;
	}
	
	public ArrayList<Product> selectByUserKeyword(Connection conn,String keyword) {
			ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement  pstmt = null;
		ResultSet  rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE  ? OR USER_ID LIKE ?";
	
		try {
			pstmt = conn.prepareStatement(sql);
			//방법 1일 경우
			//pstmt.setString(1,userName);
			
			//방법 2일 경우
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				
				p.setId(rset.getString("product_id"));
				p.setName(rset.getString("p_name"));
				p.setPrice(rset.getInt("price"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setStock(rset.getInt("stock"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				
		return list;
	}
		
		
	// 삽입
	public int insertProduct(Product p1) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DBADMIN", "java1234");
			pstmt = conn.prepareStatement(sql);

//			pstmt.setString(1, m.getUserId());

			pstmt.setString(1, p1.getId());
			pstmt.setString(2, p1.getName());
			pstmt.setInt(3, p1.getPrice());
			pstmt.setString(4, p1.getDescription());
			pstmt.setInt(5, p1.getStock());

			result = pstmt.executeUpdate();

			if (result > 0) { // 성공
				conn.commit();
			} else { // 실패
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// 삭제
	public int deleteProduct(String id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM PRODUCT WHERE product_id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DBADMIN", "java1234");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			result = pstmt.executeUpdate();

			if (result > 0) { // 성공
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// 수정
	public int updateProduct(Product p1) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE PRODUCT SET  P_NAME = ?,   PRICE = ?, DESCRIPTION = ?,	STOCK = ?  where product_id =?";

		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DBADMIN", "java1234");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p1.getId());
			pstmt.setString(2, p1.getName());
			pstmt.setInt(3, p1.getPrice());
			pstmt.setString(4, p1.getDescription());
			pstmt.setInt(5, p1.getStock());

			result = pstmt.executeUpdate();

			if (result > 0) { // 성공
				conn.commit();
			} else { // 실패
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}




}

