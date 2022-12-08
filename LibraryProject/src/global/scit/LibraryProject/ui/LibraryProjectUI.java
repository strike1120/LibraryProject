package global.scit.LibraryProject.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import global.scit.LibraryProject.service.LibraryService;
import global.scit.LibraryProject.vo.Book;
import global.scit.LibraryProject.vo.RentAndUsers;
import global.scit.LibraryProject.vo.RentVO;

public class LibraryProjectUI {
	Scanner keyin = new Scanner(System.in);
	LibraryService service = new LibraryService();

	public LibraryProjectUI() {

		String choice;

		while (true) {
			menu2();
			choice = keyin.next();
			switch (choice) {
			case "1":
				Allbook();
				break;
			case "2":
				registbook();
				break;
			case "3":
				delete();
				break;
			case "4":
				update();
				break;
			case "5":
				rentbook();
				break;
			case "6":
				returnbook();
				break;
			case "7":
				//뒤로가기
				break;
			case "0": // 종료
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
			default:
				System.out.println(" 다시 선택해 주세요. ");
			}
		}
	}




	// 도서반납
	private void returnbook() {
		System.out.println("\n [ 도서 반납 ]");
		int number;

		System.out.print(" > 책 제목을 입력하세요 : ");
		number = keyin.nextInt();

		int result = service.returnbook(number);

		if (result == 1) {
			System.out.println("** 책이 반납되었습니다.");
			return;
		}
		System.out.println("책 반납을 실패하였습니다.");
	}

	//도서대출
	private void rentbook() {
		System.out.println("\n [ 도서 대여 ]");
		int numbers;
		// 로그인
		System.out.print(" > 도서 번호를 입력하세요 : ");
		numbers = keyin.nextInt();
		
		//도서조회
		Book result = service.selectOne(numbers);

		if (result != null) {
			
			System.out.println("회원 번호를 입력하세요");
			int num1 = keyin.nextInt();
			System.out.println("대여할 책 번호를 입력하세요");
			int num2 = keyin.nextInt();
			
			RentAndUsers rau1= new RentAndUsers(num1,num2);
			RentAndUsers rau2= new RentAndUsers("역행자",2);
			
			
			int result1 = service.updateRentInfo(rau1);
			int result2 = service.updateUserInfo(rau2);
			if(result1 == 1 && result2 == 1) {
				System.out.println("** 책이 대여되었습니다.");
				System.out.println("책 반납날짜는 0000입니다.");
				return;
			}
		}

	}

	
//도서 조회
	private void selectIsbn() {
		String isbn;

		System.out.println("  [ 도서 조회 ]");
		System.out.print("> ISBN입력 : ");
		isbn = keyin.next();

		Book vo = service.selectIsbn(isbn);

		if (vo == null) {
			System.out.println("** 책이 없습니다.");
			return;
		}
		System.out.println(vo);
	}

	//도서조회
	private void selectOne() {
		int numbers = 0;

		System.out.println("  [ 도서 조회 ]");
		System.out.print("> 책 번호 : ");
		numbers = keyin.nextInt();

		Book vo = service.selectOne(numbers);

		if (vo == null) {
			System.out.println("** 책이 없습니다.");
			return;
		}
		System.out.println(vo);
	}

	//도서 재고량 수정
	private void update() {
		String isbn;
		int stock;
		System.out.println("> ISBN 번호 : ");
		isbn = keyin.next();

		Book vo = service.selectIsbn(isbn);

		if (vo == null) {
			System.out.println("해당 번호가 없습니다.");
			return;
		}

		System.out.println(">수량 : ");
		stock = keyin.nextInt();

		Book vo1 = new Book(isbn, stock);
		int result = service.update(vo1);

		if (result == 1) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 오류");
		}

	}

	//도서 삭제
	private void delete() {
		System.out.println("\n [ 도서 삭제 ]");
		int number;

		System.out.print(" > 책 번호 : ");
		number = keyin.nextInt();

		Book vo = service.selectOne(number);
		if (vo == null) {
			System.out.println("** 책이 없습니다.");
			return;
		}
		int result = service.delete(number);
		if (result == 1) {
			System.out.println("** 책이 삭제되었습니다.");
			return;
		}
		System.out.println("책 삭제 작업을 실패하였습니다.");

	}

	//도서 등록
	private void registbook() {
		System.out.println("   [도서 등록]   ");
		String title, isbn, author, bookcom;
		int stock;
		// char rent = 0;

		System.out.print(" > ISBN : ");
		isbn = keyin.next();

		// isbn이 같을 경우 "등록할 수 없습니다. "
		Book ro = service.selectIsbn(isbn);
		if (ro != null) {
			System.out.println("** 등록할 수 없는 책입니다.");
			return;
		}
		System.out.print(" > 책 제목 : ");
		title = keyin.next();
		System.out.print(" > 지은이 : ");
		author = keyin.next();
		System.out.print(" > 출판사 : ");
		bookcom = keyin.next();
		System.out.print(" > 보유권수 : ");
		stock = keyin.nextInt();

		Book vo = new Book(isbn, title, author, bookcom, stock);

		int result = service.registbook(vo);
		if (result == 1) {
			System.out.println("** 도서 등록되었습니다.");
			System.out.println(vo);
		} else
			System.out.println("** 도서 등록 실패입니다.");

	}

	// 전체 책 조회
	private void Allbook() {
		System.out.println("\n [ 도서 전체 조회 ]");

		List<Book> list = service.Allbook();

		if (list.isEmpty()) {
			System.out.println("없음");
			return;
		}

		for (Book b : list) {
			System.out.println(b);
		}

//		if (list.size() == 0) {
//			System.out.println("**현재 책이 없습니다.");
//			return;
//		}
//		Iterator<Book> iter = list.iterator();
//
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
	}

	



	// menu2 : 관리자모드
	private void menu2() {
		System.out.println("------------------------");
		System.out.println("      [ SCIT 도서관 ]     ");
		System.out.println();
		System.out.println("   1. 도서 목록 조회");
		System.out.println("   2. 도서 등록");
		System.out.println("   3. 도서 삭제");
		System.out.println("   4. 도서 재고 수정");
		System.out.println("   5. 도서 대출");
		System.out.println("   6. 도서 반납");
		System.out.println("   7. 뒤로가기");
		System.out.println("   0. 종     료");
		System.out.println();
		System.out.println("------------------------");
		System.out.print("   > 선택 : ");
	}

	// menu3 : 이용자모드
	private void menu3() {
		System.out.println("------------------------");
		System.out.println("      [ 이용자 모드 ]     ");
		System.out.println();
		System.out.println("   1. 대     여");
		System.out.println("   2. 반     납");
		System.out.println("   3. 뒤로가기");
		System.out.println("   0. 종     료");
		System.out.println();
		System.out.println("------------------------");
		System.out.print("   > 선택 : ");
	}
}