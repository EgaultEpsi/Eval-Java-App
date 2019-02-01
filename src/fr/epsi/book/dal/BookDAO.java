package fr.epsi.book.dal;

import fr.epsi.book.domain.Book;
import fr.epsi.book.domain.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class BookDAO implements IDAO<Book, Long> {
	private static final String INSERT_QUERY = "INSERT INTO book (id, statut) values (?,?)";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM book WHERE id=?";
	private static final String FIND_ALL_QUERY = "SELECT * FROM book";
	private static final String UPDATE_QUERY = "UPDATE book SET code=? WHERE id=?";
	private static final String REMOVE_QUERY = "DELETE FROM book WHERE id = ?";

	
	
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
