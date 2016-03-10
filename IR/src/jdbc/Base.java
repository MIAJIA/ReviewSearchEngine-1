package jdbc;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class Base {


	public static void main( String args[] ) throws Exception{
		//				template();

		//		try{   
		//		Connection conn = null;
		//		Statement st = null;
		//		ResultSet rs = null;
		//		try {
		//			// 2.建立连接
		//			conn = JdbcUtils.getConnection();
		//			// conn = JdbcUtilsSing.getInstance().getConnection();
		//			// 3.创建语句
		//			st = conn.createStatement();
		//			//				st = conn.insert()
		//			// 4.执行语句
		//			rs = st.executeQuery("select * from user");
		//
		//			// 5.处理结果
		//			while (rs.next()) {
		//				// 参数中的1,2,3,4是指sql中的列索引
		//				System.out.println(rs.getObject(1) + "\t" + rs.getObject(2)
		//						+ "\t" + rs.getObject(3) + "\t" + rs.getObject(4));
		//			}
		//
		//		}catch(Exception e){
		//			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		//		}finally {
		//			JdbcUtils.free(rs, st, conn);


		// To connect to mongodb server
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

		List<String> databases = mongoClient.getDatabaseNames();
		// Now connect to your databases
		//		DB db = mongoClient.getDB("test");
		System.out.println("Connect to database successfully");
		//		boolean auth = db.authenticate("mia", "123");
		//		System.out.println("Authentication: "+auth);
		//		DBCollection coll = db.createCollection("mycol", null);
		System.out.println("Collection created successfully");

		//		for (String dbName : databases) {
		//			System.out.println("- Database: " + dbName);
		//			DB mydb = mongoClient.getDB(dbName);
		//			Set<String> collections = mydb.getCollectionNames();
		//			for (String colName : collections) {
		//				System.out.println("\t + Collection: " + colName);
		//			}
		//		}
		DB mydb = mongoClient.getDB("keywords");

		DBCollection coll = mydb.getCollection("companys");
		//delete
		//		 DBObject myDoc = coll.findOne();
		//		 coll.remove(myDoc);

		BasicDBObject doc = new BasicDBObject("_id", "56db7279cd65d9841c1fded3").
				append("title", "Quora电面20160119").
				append("href", "http://www.jiuzhang.com/interview/81").
				append("description", "\n            电面，对方是拉丁裔的女生，有点困，打了几个哈气。。。简单说了下project，然后开始算法题1. m...\n").
				append("company", "Quora").
				append("year", "2016").
				append("__v",0);
		coll.insert(doc);
		doc = new BasicDBObject("_id", "56db7279cd65d9841c1fded4").
				append("title", "Linkedin Onsite 面经").
				append("href", "http://www.jiuzhang.com/interview/80").
				append("description", "\n            第一轮lunch，随便聊。。。（11点开始，直接先去吃了午饭）第二轮host manager，主要介...\n").
				append("company", "Linkedin").
				append("year", "2015").
				append("__v",0);
		coll.insert(doc);
		System.out.println("Document inserted successfully");
//		DBCursor cursor = coll.find();
//		int i=1;
//		while (cursor.hasNext()) { 
//			System.out.println("Inserted Document: "+i); 
//			System.out.println(cursor.next()); 
//			i++;
//		}

		mongoClient.close();

		//		boolean auth = db.authenticate("mia","123" );
		//		System.out.println("Authentication: "+auth);         

		//		DBCollection coll = db.getCollection("mycol");
		//		System.out.println("Collection mycol selected successfully");

		//		DBCursor cursor = coll.find();
		//		int i = 1;
		//
		//		while (cursor.hasNext()) { 
		//			System.out.println("Inserted Document: "+i); 
		//			System.out.println(cursor.next()); 
		//			i++;
		//		}


	}


}

