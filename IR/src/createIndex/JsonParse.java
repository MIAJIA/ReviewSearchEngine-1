package createIndex;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//this is a test file
public class JsonParse {




	public static void main(String[] args) 


	{
		//		final String filePath = "/Users/pingguo/Downloads/Programming/tmp/IR/meta.json";
		final String filePath = "meta.json";
		JSONParser jsonParser = new JSONParser();
		HashMap<String, ArrayList<JSONObject>> companyMap = new HashMap <String, ArrayList<JSONObject>> ();

		try{
			JSONArray jsonArr = (JSONArray) jsonParser.parse( new FileReader(filePath));

			for (Object o : jsonArr) {
				JSONObject obj = (JSONObject) o;
				String company = (String) obj.get("company");
				if(!companyMap.containsKey(company)){
					ArrayList<JSONObject> list = new ArrayList<JSONObject>();
					list.add(obj);
					companyMap.put(company, list);
				} else {
					companyMap.get(company).add(obj);
				}
			}

			
			//			// get a String from the JSON object
			//			String _id = (String) jsonObject.get("_id");
			//			System.out.println("The first name is: " + _id);

			//			// get an array from the JSON object
			//			JSONArray lang= (JSONArray) jsonObject.get("languages")		
			//			// take the elements of the json array
			//			for(int i=0; i<lang.size(); i++){
			//				System.out.println("The " + i + " element of the array: "+lang.get(i));
			//			}
			//			Iterator i = lang.iterator();

			// take each value from the json array separately
			//			while (i.hasNext()) {
			//				JSONObject innerObj = (JSONObject) i.next();
			//				System.out.println("language "+ innerObj.get("lang") + 
			//						" with level " + innerObj.get("knowledge"));
			//			}
			//			// handle a structure into the json object
			//			JSONObject structure = (JSONObject) jsonObject.get("job");
			//			System.out.println("Into job structure, name: " + structure.get("name"));

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}



	}
}


