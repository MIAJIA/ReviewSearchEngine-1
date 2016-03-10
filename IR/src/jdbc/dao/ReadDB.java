package jdbc.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class ReadDB {

	public static void main(String[] args) 


	{	
		JSONParser parser = new JSONParser();


		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		List<String> databases = mongoClient.getDatabaseNames();
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
