package jdbc.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public final class MongoSingle {
	//	private static String url ="mongodb://mia:123@ds053305.mlab.com:53305/miadb";
	//	private static String url = "jdbc:mysql://localhost:27017/jdbc";
	//	private static String user = "root";
	//	private static String password = "";

	private MongoSingle() {}
	private static MongoClient instance = null;

	public static MongoClient getInstance() {
		if(null == instance) {
			synchronized( MongoSingle.class) {
				if(instance == null) {
					instance = new MongoClient( "localhost" , 27017 );
				}
			}
		}
		return instance;
	}


	//	static {
	//		try {
	//			Class.forName("mongodb.jdbc.MongoDriver");
	//		} catch (ClassNotFoundException e) {
	//			throw new ExceptionInInitializerError(e);
	//		}
	//	}

	public static DB getDB(String dbname) {
		return instance.getDB(dbname);
	}
//	public static DBCollection getCollection(String dbname, String collname) {
//		return instance.getDB(dbname).getCollection(collname);
//	}
//	public static DBCursor getCursor(String dbname, String collname) {
//		return instance.getDB(dbname).getCollection(collname).find();
//	}
	public static void free() {
		try {
			instance.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
