package fr.epsi.book.dal;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<E, ID> {
	
	public void create( E o ) throws SQLException;
	
	public E findById( ID id );
	
	public List<E> findAll();
	
	public E update( E o );
	
	public void remove( E o );
}
