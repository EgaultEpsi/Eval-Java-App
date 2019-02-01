package fr.epsi.book.dal;

import fr.epsi.book.domain.Contact;
import fr.epsi.book.domain.Contact.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO implements IDAO<Contact, Long> {

	private static final String INSERT_QUERY = "INSERT INTO contact (id, name, email, phone, type_num) values (?,?,?,?,?)";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM contact WHERE id=?";
	private static final String FIND_ALL_QUERY = "SELECT * FROM contact";
	private static final String UPDATE_QUERY = "UPDATE contact SET name=?,email=?,phone=?,type_num=? WHERE id=?";
	private static final String REMOVE_QUERY = "DELETE FROM contact WHERE id=?";

	public void create(Contact c) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		PreparedStatement st = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, c.getId());
		st.setString(2, c.getName());
		st.setString(3, c.getEmail());
		st.setString(4, c.getPhone());
		st.setInt(5, c.getType().ordinal());

		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();

		if (rs.next()) {
			c.setId(rs.getString(1));
		}
	}

	public Contact findById(String idCherche) throws SQLException {
		//
		Connection connection = PersistenceManager.getConnection();
		PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY);
		st.setString(1, idCherche);
		ResultSet rs = st.executeQuery();
		Contact contact = null;

		if (rs.next()) {
			contact = new Contact();
			contact.setId(rs.getString("id"));
			contact.setName(rs.getString("name"));
			contact.setEmail(rs.getString("email"));
			contact.setPhone(rs.getString("phone"));
			if (rs.getInt("type_num") == 0) {
				contact.setType(Type.PERSO);
			} else {
				contact.setType(Type.PRO);
			}
		}
		return contact;
	}

	@Override
	public List<Contact> findAll() throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		PreparedStatement st = connection.prepareStatement(FIND_ALL_QUERY);
		ResultSet rs = st.executeQuery();
		List<Contact> contact = new ArrayList<>();
		Contact unContact = new Contact();

		while (rs.next()) {
			unContact.setId(rs.getString("id"));
			unContact.setName(rs.getString("name"));
			unContact.setEmail(rs.getString("email"));
			unContact.setPhone(rs.getString("phone"));
			if (rs.getInt("type_num") == 0) {
				unContact.setType(Type.PERSO);
			} else {
				unContact.setType(Type.PRO);
			}
			contact.add(unContact);
		}
		return contact;
	}

	public Contact update(Contact c) throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		PreparedStatement st = connection.prepareStatement(UPDATE_QUERY);
		st.setString(1, c.getName());
		st.setString(2, c.getEmail());
		st.setString(3, c.getPhone());
		st.setInt(4, c.getType().ordinal());
		st.setString(5, c.getId());
		st.executeUpdate();
		return findById(c.getId());
	}

	public void remove(Contact c) throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		PreparedStatement st = connection.prepareStatement(REMOVE_QUERY);
		st.setString( 1, c.getId() );
		st.executeUpdate();
	}

	@Override
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
