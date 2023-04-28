package com.dy.service;


import java.sql.Connection;
import java.util.ArrayList;

import com.dy.common.JDBCTemplate;
import com.dy.model.Dao;
import com.dy.vo.Product;



public class Service {

	public int insertMember(Product p) {
	
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new Dao().insertProduct(p);
		
		// 트랜잭션 처리
		if(result > 0) { //성공
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	public ArrayList<Product> selectList(){
		Connection conn = JDBCTemplate.getConnection();
	
		ArrayList<Product> list = new Dao().selectList(conn);

		JDBCTemplate.close(conn);
		return list;
	}
	

	public Product selectByUserId(String Id) {
		Connection conn = JDBCTemplate.getConnection();
		
		Product p = new Dao().selectByUserId(conn, Id);
		JDBCTemplate.close(conn);
		return p;
	}
	
	
	public ArrayList<Product> selectByUserKeyword(String keyword){
		Connection conn = JDBCTemplate.getConnection();
	
		ArrayList<Product> list = new Dao().selectByUserKeyword(conn,keyword);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int updateProduct(Product p) {
		Connection conn = JDBCTemplate.getConnection();

		int result = new Dao().updateProduct(p);
		
		// 트랜잭션 처리
		if(result > 0) { //성공
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	

	
	public Product selectProfile(String Id,String Name) {
		
		Connection conn = JDBCTemplate.getConnection();

		Product p = new Service().selectProfile(Id, Name);
		
		JDBCTemplate.close(conn);
		
		return p;
	}
}