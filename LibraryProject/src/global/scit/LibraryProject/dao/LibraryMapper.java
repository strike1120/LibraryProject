package global.scit.LibraryProject.dao;

import java.util.List;

import global.scit.LibraryProject.vo.Book;
import global.scit.LibraryProject.vo.RentAndUsers;



public interface LibraryMapper {
	public int registbook(Book vo); //도서 등록
	public List<Book> Allbook(); //도서 전체 조회
	public int update(Book vo);// 도서 재고량 수정
	public int delete(int numbers); //도서 한권 삭제
	
	public int updateRentInfo(RentAndUsers rau1);
	public int updateUserInfo(RentAndUsers rau2);
	
	public int returnbook(int numbers); //
	public int rentbook(int numbers); //
	public Book selectOne(int numbers);
	public Book selectIsbn(String isbn);
}