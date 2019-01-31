package fr.epsi.book.dal;

import fr.epsi.book.domain.Contact;

import java.sql.*;
import java.util.List;

public class ContactDAO implements IDAO<Contact, Long> {
	
	private static final String INSERT_QUERY = "INSERT INTO contact (name, email, phone, type_var, type_num) values (?,?,?,?,?)";
	private static final String FIND_BY_ID_QUERY = "A DEFINIR";
	private static final String FIND_ALL_QUERY = "A DEFINIR";
	private static final String UPDATE_QUERY = "A DEFINIR";
	private static final String REMOVE_QUERY = "A DEFINIR";
	
	@Override
	public void create( Contact c ) throws SQLException {
		
		Connection connection = PersistenceManager.getConnection();
		PreparedStatement st = connection.prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS );
		st.setString( 1, c.getName() );
		st.setString( 2, c.getEmail() );
		st.setString( 3, c.getPhone() );
		st.setString( 4, c.getType().getValue() );
		st.setInt( 5, c.getType().ordinal() );
		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();
		
		if ( rs.next() ) {
			c.setId( rs.getString( 1 ) );
		}
	}
	
	@Override
	public Contact findById( Long aLong ) {
		//TODO
		return null;
	}
	
	@Override
	public List<Contact> findAll() {
		//TODO
		return null;
	}
	
	@Override
	public Contact update( Contact o ) {
		//TODO
		return null;
	}
	
	@Override
	public void remove( Contact o ) {
		//TODO
	}
}


