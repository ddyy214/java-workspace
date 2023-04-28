package com.book.controller;

import java.util.ArrayList;

import com.book.model.dao.Dao;
import com.book.model.vo.Book;
import com.book.view.MainMenu;


public class Controller {
//추가
	public void addbook(String bookid, String bookname, String publisher, String price) {

		Book v = new Book(bookid, bookname,publisher,price);


		int result = new Dao().addbook(v);
		if(result > 0) { //성공
			new MainMenu().displaySuccess("성공적으로 추가되었습니다.");
		}else {          //실패
			new MainMenu().displayFail("추가에 실패했습니다.");
		}
		}

//조회
	
//삭제
	public void deleteBook(String bookId) {
		int result = new Dao().deleteBook(bookId);
		
		if(result > 0) { //성공
			new MainMenu().displaySuccess("성공적으로 삭제했습니다.");
		}else {
			new MainMenu().displayFail("삭제하는데 실패했습니다.");
		}
	}
	
}