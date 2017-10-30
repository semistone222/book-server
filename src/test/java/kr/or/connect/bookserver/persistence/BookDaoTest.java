package kr.or.connect.bookserver.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.bookserver.domain.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookDaoTest {
	
	@Autowired
	private BookDao dao;
	
	@Test
	public void shouldSelectAll() {
		List<Book> allBooks = dao.selectAll();
		assertThat(allBooks, is(notNullValue()));
	}

	@Test
	public void shouldCount() {
		int count = dao.countBooks();
		System.out.println(count);
	}
	
	@Test
	public void shouldInsertAndSelect() {
		// given
		Book book = new Book("Java Web", "Naver", 342);

		// when
		Integer id = dao.insert(book);

		// then
		Book selected = dao.selectById(id);
		System.out.println(selected);
		assertThat(selected.getTitle(), is("Java Web"));
	}
	
	@Test
	public void shouldDelete() {
		// given
		Book book = new Book("Naver Java", "Naver", 142);
		Integer id = dao.insert(book);

		// when
		int affected = dao.deleteById(id);

		// Then
		assertThat(affected, is(1));
	}
	
	@Test
	public void shouldUpdate() {
		// Given
		Book book = new Book("Naver Java", "Naver", 142);
		Integer id = dao.insert(book);

		// When
		book.setId(id);
		book.setTitle("Naver Java2");
		int affected = dao.update(book);

		// Then
		assertThat(affected, is(1));
		Book updated = dao.selectById(id);
		assertThat(updated.getTitle(), is("Naver Java2"));
	}
}
