package com.book.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.book.model.vo.Vo;

public class Dao {

//추가
	public int addbook(Vo v1) {
		
		int result = 0;
		
		Connection        conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO BOOK VALUES(?,?,?,?)";		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, v1.getBookid()); // bookId
			pstmt.setString(2, v1.getBookname());// bookName
			pstmt.setString(3, v1.getPublisher());// publisher
			pstmt.setString(4, v1.getPrice());// price

			
			result = pstmt.executeUpdate();
			
			if(result > 0) {  // 성공
				conn.commit();
			}else {           // 실패
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
