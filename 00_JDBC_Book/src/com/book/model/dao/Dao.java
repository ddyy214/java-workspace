package com.book.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.book.model.vo.Book;

public class Dao {

//추가
	public int addbook(Book v1) {
		
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
//조회
	public ArrayList<Book> selectList(String bookid) {
		ArrayList<Book> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet  rset = null;
		
		String sql = "SELECT * FROM BOOK";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book v = new Book();
			
				v.setBookid(rset.getString("bookid"));  
				v.setBookname(rset.getString("bookname"));
				v.setPublisher(rset.getString("publisher"));
				v.setPrice(rset.getString("price"));
			
				list.add(v);
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
	
//삭제
	
	public int deleteBook(String bookId) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement  pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USER_ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookId);
			result = pstmt.executeUpdate();
			
			if(result > 0) { //성공
				conn.commit();
			}else {
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

	
	
}
