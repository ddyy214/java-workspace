package com.book.controller;

import com.book.model.dao.Dao;
import com.book.model.vo.Vo;
import com.book.view.MainMenu;


public class Controller {
	
	public void addbook(String bookid, String bookname, String publisher, String price) {
		
		Vo v1 = new Vo(bookid,bookname,publisher,price);
		
		
		int result = new Dao().addbook(v1);
		
		if(result > 0) { //성공
			new MainMenu().displaySuccess("성공적으로 추가되었습니다.");
		}else {          //실패
			new MainMenu().displayFail("작업이 실패하였습니다.");
		}
	}
	
}