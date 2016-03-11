package jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class base {
	public static void main( String args[] ) throws Exception{
		template();
	}
	static void template() throws Exception {   
		MongoClient conn = null;
		DB mydb = null;
		DBCollection coll = null;
		DBCursor cursor = null;
		try {
			conn = MongoSingle.getInstance();
			System.out.println("Connect to database successfully");
			mydb = conn.getDB("keywords");
			System.out.println(" Get DB successfully");
			coll = mydb.getCollection("company");
			cursor = coll.find();


			while (cursor.hasNext()) {
				// 参数中的1,2,3,4是指sql中的列索引
				System.out.println(rs.getObject(1) + "\t" + rs.getObject(2)
						+ "\t" + rs.getObject(3) + "\t" + rs.getObject(4));
			}

		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}finally {
			MongoSingle.free();
		}



	}
}
