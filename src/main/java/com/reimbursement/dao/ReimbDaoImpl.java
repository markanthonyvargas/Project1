package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import com.reimbursement.LoggerUtil;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;

public class ReimbDaoImpl implements ReimbDao {
	final static Logger loggy = Logger.getLogger(ReimbDaoImpl.class);
	
	// database information
	public static String url = "jdbc:postgresql://database-1.cjnmggtxpdlq.us-west-1.rds.amazonaws.com/ersDB";
	public static String username = "AWSDatabase";
	public static String password = "p4ssw0rd";

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}

	public ReimbDaoImpl() {

	}

	public ReimbDaoImpl(String _url, String _username, String _password) {
		url = _url;
		username = _username;
		password = _password;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_users;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (users.size() == 0) {
			loggy.error("Error obtaining all users");
			loggy.info("error obtaining all users");
			return null;
		}
		else {
			loggy.trace("Selected all users.");
			return users;
		}
	}

	@Override
	public List<Reimbursement> selectAllReimbs() {
		List<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_reimbursement ORDER BY reimb_id DESC;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (reimbs.size() == 0) {
			loggy.error("Error obtaining all reimbursements");
			return null;
		}
		else {
			loggy.trace("Selected all reimbursments");
			return reimbs;
		}
	}

	@Override
	public User selectUser(String u, String p) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_users WHERE ers_username = '" + u + "' AND ers_password = '" + p + "';";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		loggy.trace("Successfully selected user: " + u);
		LoggerUtil.logger.info("Successfully selected user: " + u);
		return user;
	}

	@Override
	public List<Reimbursement> selectReimbByUser(int id) {
		List<Reimbursement> listOfReimbs = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = " + id + " ORDER BY reimb_id DESC;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				listOfReimbs.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		loggy.trace("Selected all reimbursements started by userID " + id);
		return listOfReimbs;
	}

	@Override
	public boolean insertReimbursement(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) "
					+ "VALUES(?, current_timestamp, ?, ?, ?, ?);";
			// INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted,
			// reimb_description, reimb_author, reimb_status_id, reimb_type_id)
			// VALUES (250.00, current_timestamp, 'example reimb', 2, 1, 4);
			PreparedStatement state = conn.prepareStatement(sql);
			state.setDouble(1, r.getAmount());
			state.setString(2, r.getDescription());
			state.setInt(3, r.getAuthor());
			state.setInt(4, r.getStatusID());
			state.setInt(5, r.getTypeID());

			state.executeUpdate();
			
			loggy.trace("Successfully created new reimbursement.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		loggy.error("Error adding reimbursement");
		return false;
	}

	@Override
	public boolean updateStatus(int reimbID, int statusID, int roleID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = " + statusID + ", "
					+ "reimb_resolved = current_timestamp, reimb_resolver = " + roleID + 
					" WHERE reimb_id = " + reimbID + ";";
			Statement state = conn.createStatement();
			state.execute(sql);
			loggy.trace("Reimbursement updated successfully");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		loggy.error("Unable to update reimbursement " + reimbID);
		return false;
	}
	
	@Override
	public void h2InitDao() {
		//I am inserting two pokemon "types" into the database, but my Pokemon model in the model layer
		//	only uses one type. I simplified the model for demo purposes. AND to demo that your model can
		//	differ from the actual database table, in JDBC.
		
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= ""+
			"CREATE TABLE ers_reimbursement("+ 
			"	reimb_id SERIAL PRIMARY KEY" + 
			"	, reimb_amount NUMERIC NOT NULL" + 
			"	, reimb_submitted TIMESTAMP NOT NULL" + 
			"	, reimb_resolved TIMESTAMP" + 
			"	, reimb_description VARCHAR(250)" + 
			"	, reimb_receipt BYTEA" + 
			"	, reimb_author INTEGER NOT NULL" + 
			"	, reimb_resolver INTEGER" + 
			"	, reimb_status_id INTEGER" + 
			"	, reimb_type_id INTEGER" + 
			"	, FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id)" + 
			"	, FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id)" + 
			"	, FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id)" + 
			"	, FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id)" + 
			");"+
					"INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)" + 
					"VALUES (250.00, current_timestamp, 'example reimb', 2, 1, 4);";
			
			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void h2DestroyDao() {
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= ""+
			"DROP TABLE ers_reimbursement; ";
			
			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
