package global.scit.LibraryProject.service;

import java.util.List;

import global.scit.LibraryProject.dao.LibraryDAO;
import global.scit.LibraryProject.vo.Book;
import global.scit.LibraryProject.vo.RentAndUsers;
import global.scit.LibraryProject.vo.RentVO;

public class LibraryService {
	LibraryDAO dao = new LibraryDAO();

	public List<Book> Allbook() {
		List<Book> list = dao.Allbook();
		return list;
	}

	public int registbook(Book vo) {
		int result = dao.registbook(vo);
		return result;
	}

	public int delete(int numbers) {
		int result = dao.delete(numbers);
		return result;
	}

	public int returnbook(int number) {
		int result = dao.returnbook(number);
		return result;
		// 재고 수량을 1증가.

	}

	public int rentbook(int numbers) {
		int result = dao.rentbook(numbers);
		return result;
	}

	public Book selectOne(int numbers) {
		Book vo = dao.selectOne(numbers);
		return vo;

	}

	public Book selectIsbn(String isbn) {
		Book vo = dao.selectIsbn(isbn);
		return vo;
	}

	public int update(Book vo1) {
		int result = dao.update(vo1);
		return result;
	}

	public int updateRentInfo(RentAndUsers rau1) {
		int result = dao.updateRentInfo(rau1);
		return result;
	}

	public int updateUserInfo(RentAndUsers rau2) {
		int result = dao.updateUserInfo(rau2);
		return result;
	}

}