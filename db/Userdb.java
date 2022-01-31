package db;

import pkg.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

class Userdb {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/jsontest";
	
	public Userdb() throws SQLException {
		//Class.forName("org.postgresql.Driver");
		this.conn = DriverManager.getConnection(DB_URL);
		this.queryrunner = new QueryRunner();
	}
	public Connection getConn() {
		return conn;
	}
	/* Create a new user and add it to the database via the Userdb object (this class).
	   Then get all users from the database and display them.
	   Note that roles column is not in the database, so setting a user role and hoping to see
	   it appear when reading the database will leave you disenchanted.
	*/
	public static void main(String[] args) throws SQLException {
		System.out.println("Connect to db");
		Userdb udb=new Userdb();
		User u = new User("Test1", "User1","test1user1@example.com");
		List<String> newroles = u.getRoles();
		newroles.add("dbuser");
		u.setRoles(newroles);
		System.out.println("Adding user "+u.print());
		// put user in database
		udb.insert_user(u);
		// read users from database.
		// All users will have the 'user' role which was set in the contructor.
		udb.getUsersFromDb();
		DbUtils.close(udb.getConn());

	}
	public void insert_user(User u) throws SQLException {
		// insert something
		System.out.println("Inserting user into db: "+u.print());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int count = queryrunner.update(conn,
			"INSERT INTO users(firstname,lastname,email,created_on) VALUES (?,?,?,?)",
			u.getFirstname(),u.getLastname(),u.getEmail(),timestamp);
		System.out.println(count + " record(s) inserted");
	}
	public void getUsersFromDb() throws SQLException {
		try {
			ResultSetHandler<List<User>> resultHandler = new BeanListHandler<User>(User.class);
			List<User> users = queryrunner.query(conn, "SELECT * FROM users", resultHandler);
			for(User u: users ) {
				System.out.println(u.print());
				System.out.println("***");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection conn;
	private QueryRunner queryrunner;

};
