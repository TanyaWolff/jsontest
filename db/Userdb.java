package db;

import pkg.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

	public static void main(String[] args) throws SQLException {
		System.out.println("Connect to db");
		Userdb udb=new Userdb();
		User u = new User("Test1", "User1","test1user1@example.com");
		udb.insert_user(u);
		DbUtils.close(udb.getConn());
	}
	public void insert_user(User u) throws SQLException {
		// insert something
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int count = queryrunner.update(conn,
			"INSERT INTO users(id,firstname,lastname,email,created_on) VALUES (?,?,?,?,?)",
			14,u.getFirstname(),u.getLastname(),u.getEmail(),timestamp);
		System.out.println(count + " record(s) inserted");
	}

	private Connection conn;
	private QueryRunner queryrunner;

};
