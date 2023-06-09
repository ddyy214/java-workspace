package com.book.view;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

import com.book.controller.Controller;

//사용자가 보게될 화면 구성

public class MainMenu {
	
	private Scanner sc = new Scanner(System.in);
	private Controller cl = new Controller();
	
	public void mainMenu() {
	
		while(true) {
			
			System.out.println("\n==도서관리 프로그램==");
			System.out.println("1. 도서 추가");
			System.out.println("2. 전체 도서 조회");
			System.out.println("3. 도서삭제(도서번호)");
			System.out.println("0. 프로그램 종료");
		
			System.out.println(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: addbook(); break;   
			case 2: selectList(); break;    
			case 3: deleteBook(); break;    
			case 0: System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("메뉴를 잘못입력했습니다. 다시 입력해주세요.");
			}
		}
	}	
	
	//도서추가
	public void addbook() {
		System.out.println("\n== 도서 추가 ==");
		
		System.out.println("번호 : ");
		String bookid = sc.nextLine();
		
		System.out.println("책제목 : ");
		String bookname = sc.nextLine();

		System.out.println("출판사 : ");
		String publisher = sc.nextLine();
		
		System.out.println("가격 : ");
		String price = sc.nextLine();
		
		cl.addbook(bookid, bookname, publisher, price);
	}
	

	public void selectList() {
	      
	}
	private void deleteBook() {
		
	}
	//삭제할 번호
	public String inputId(Book Id) {
		System.out.println("\n삭제할 번호 : ");
		return sc.nextLine();
	}
	
	
	//------응답 화면----
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
	public void displayMemberList(ArrayList<Book> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.\n");
		
		for(Book v: list) {
			System.out.println(v);
		}
	}
	
}
