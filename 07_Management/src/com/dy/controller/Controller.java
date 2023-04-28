package com.dy.controller;

import java.util.ArrayList;

import com.dy.model.Dao;
import com.dy.service.Service;
import com.dy.view.MainMenu;
import com.dy.vo.Product;

public class Controller {

//	 * 1. 회원 추가 요청을 처리하는 메서드

	public void insertProduct(String id, String p_name, int price, String description, int stock) {

		Product p = new Product(id, p_name, price, description, stock);

		int result = new Dao().insertProduct(p);

		if (result > 0) { // 성공
			new MainMenu().displaySuccess("성공적으로 추가되었습니다.");
		} else { // 실패
			new MainMenu().displayFail("제품 추가에 실패했습니다.");
		}
	}

//	 * 2. 회원전체를 조회요청을 처리하는 메서드

	public void selectList() {
		ArrayList<Product> list = new Service().selectList();

		if (list.isEmpty()) { // 리스트가 비어있을 경우 => 조회된 결과 없음.
			new MainMenu().displayNoData("조회 결과 데이터가 없습니다.");
		} else {
			new MainMenu().displayMemberList(list);
		}

	}

		public void selectById(String keyword) {
			ArrayList<Product> list = new Service().selectByUserKeyword(keyword);
			
			
			if(list.isEmpty()) {
				new MainMenu().displayNoData(keyword+"라는 키워드에 해당하는 제품이 없습니다.");
			}else {
				new MainMenu().displayMemberList(list);
			}
		}
		

	public void updateProduct(String id, String p_name, int price, String description, int stock) {
		Product p1 = new Product();
		
		p1.setId(id);
		p1.setName(p_name);
		p1.setPrice(price);
		p1.setDescription(description);
		p1.setStock(stock);
		
		int result = new Dao().updateProduct(p1);

		if (result > 0) { // 성공
			new MainMenu().displaySuccess("성공적으로 변경되었습니다.");
		} else { // 실패
			new MainMenu().displayFail("회원정보 변경에 실패했습니다.");
		}
	}


	public void deleteProduct(String id) {
		int result = new Dao().deleteProduct(id);

		if (result > 0) { // 성공
			new MainMenu().displaySuccess("제품을 삭제했습니다.");
		} else {
			new MainMenu().displayFail("제품을 삭제하는데 실패했습니다.");
		}
	}

}
