package jdbc.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ReadfromSingle {
	public static void main(String[] args) 


	{	
//		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//		List<String> databases = mongoClient.getDatabaseNames();
		DB mydb = mongoClient.getDB("keywords");
		//		 boolean auth = mydb.authenticate(myUserName, myPassword);
		//		 System.out.println("Authentication: "+auth);     
		DBCollection coll = mydb.getCollection("companys");
		DBCursor cursor = coll.find();

		try {  
			// Writing to a file  
			File file=new File("dataFromDB.json");  
			file.createNewFile();  
			FileWriter fileWriter = new FileWriter(file);  
			System.out.println("Writing JSON object to file");  
			System.out.println("-----------------------");  
			while (cursor.hasNext()) { 
				DBObject jsonobj = cursor.next();
				fileWriter.write(jsonobj.toString());  
			}
			fileWriter.flush();  
			fileWriter.close();  

		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		mongoClient.close();
	}

}
