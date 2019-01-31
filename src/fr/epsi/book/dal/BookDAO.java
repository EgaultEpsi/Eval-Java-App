package fr.epsi.book.dal;

import fr.epsi.book.domain.Book;

import java.sql.SQLException;
import java.util.List;

public class BookDAO implements IDAO<Book, Long> {
	
	@Override
	public void create( Book o ) throws SQLException {
		//TODO
	}
	
	@Override
	public Book findById( Long aLong ) {
		//TODO
		return null;
	}
	
	@Override
	public List<Book> findAll() {
		//TODO
		return null;
	}
	
	@Override
	public Book update( Book o ) {
		//TODO
		return null;
	}
	
	@Override
	public void remove( Book o ) {
		//TODO
	}
}
