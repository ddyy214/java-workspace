package com.dy.view;


import java.util.ArrayList;
import java.util.Scanner;

import com.dy.controller.Controller;
import com.dy.vo.Product;


public class MainMenu {

	private Scanner sc = new Scanner(System.in);

	private Controller mc = new Controller();

	public void mainMenu() {

		while (true) {
			System.out.println("\n==회원 관리 프로그램==");
			System.out.println("1. 상품 전체 조회"); 
			System.out.println("2. 상품 추가"); 
			System.out.println("3. 상품 수정");
			System.out.println("4. 상품삭제"); 
			System.out.println("5. 상품검색");
			System.out.println("0. 프로그램 종료");

			System.out.println(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: mc.selectList(); break; //조회
			case 2: insertProduct(); break; //추가
			case 3: updateProduct(); break; //수정
			case 4: mc.deleteProduct(inputProductId()); break; //삭제
			case 5: mc.selectById(inputProductId()); break; //검색
			case 0: System.out.println("이용해 주셔서 감사합니다.");return;
			default: System.out.println("메뉴를 잘못입력했습니다. 다시 입력해주세요.");
			}
		}
	}

	public void insertProduct() {

		System.out.println("\n== 제품 추가 ==");

		System.out.println("제품 번호: ");
		String id = sc.nextLine();

		System.out.println("제품 이름: ");
		String p_name = sc.nextLine();

		System.out.println("제품 가격: ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.println("상세 설명: ");
		String description = sc.nextLine();

		System.out.println("재 고: ");
		int stock = sc.nextInt();

		mc.insertProduct(id, p_name, price, description, stock);
	}

	// 값을 입력받고 반환해주는 함수
	public String inputProductId() {
		System.out.println("\n물품 아이디 입력 : ");
		return sc.nextLine();
	}

	public String inputMemberName() {
		System.out.println("\n물품 이름 입력 : ");
		return sc.nextLine();
	}

	public void updateProduct() {
		System.out.println("\n== 물품 정보 변경 ==");

		// 회원 아이디, 변경할 비밀번호, 변경할 이메일, 변경할 전화번호, 변경할 주소

		String id = inputProductId();

		System.out.println("변경할 물품명 : ");
		String p_name = sc.nextLine();

		System.out.println("변경할 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.println("변경할 설명 : ");
		String description = sc.nextLine();

		System.out.println("변경할 재고 : ");
		int stock = sc.nextInt();

		mc.updateProduct(id, p_name, price, description, stock);
	}

	// ----------------------응답화면-------------------------------------
	// 서비스 요청 처리후 성공했을 때 사용자가 보게될 화면
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}

	// 서비스 요청 처리 실패했을때 사용자가 보게될 화면
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}

	// 조회 서비스 요청 처리 후 조회결과가 없을 경우 사용자가 보게 될 화면
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}

	// 조회 서비스 요청 처리 후 조회결과가 여러개일 경우 사용자가 보게될 화면
	public void displayMemberList(ArrayList<Product> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.\n");

		for (Product p : list) {
			System.out.println(p);
		}
	}

	public void displayMember(Product p) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(p);
	}

}