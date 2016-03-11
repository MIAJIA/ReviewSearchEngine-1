package createIndex;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonParse2 {
	//JsonParse2.timeMap
	//	public static HashMap<String, LinkedList<String>> companyMap = new HashMap <String,LinkedList<String>> ();
	//	public static HashMap<String, LinkedList<String>> timeMap = new HashMap <String, LinkedList<String>> ();
	private HashMap<String, LinkedList<String>> companyMap = new HashMap <String,LinkedList<String>> ();
	private HashMap<String, LinkedList<String>> timeMap = new HashMap <String, LinkedList<String>> ();
	public HashMap<String, LinkedList<String>> getCompanyMap() {
		return companyMap;
	}
	public HashMap<String, LinkedList<String>> getTimeMap() {
		return timeMap;
	}

	public JsonParse2(){
		long start, end;
		//		final String filePath = "/Users/pingguo/Downloads/Programming/tmp/IR/meta.json";
		final String filePath = "meta.json";
		//		final String filePath = "dataFromDB.json";

		JSONParser jsonParser = new JSONParser();

		//		HashMap<String, ArrayList<String>> positionMap = new HashMap <String, ArrayList<String>> ();

		try{
			JSONArray jsonArr = (JSONArray) jsonParser.parse( new FileReader(filePath));
			System.out.println("Start analysis data, please wait");
			start = System.currentTimeMillis();

			for (Object o : jsonArr) {
				JSONObject obj = (JSONObject) o;
				String company = (String) obj.get("company");
				if(!companyMap.containsKey(company)){
					LinkedList<String> list = new LinkedList<String>();
					list.add((String) obj.get("_id"));
					companyMap.put(company, list);
				} else {
					companyMap.get(company).add((String) obj.get("_id"));
				}

				String time = (String) obj.get("year");
				if(!timeMap.containsKey(time)){
					LinkedList<String> list = new LinkedList<String>();
					list.add((String) obj.get("_id"));
					timeMap.put(time, list);
				} else {
					timeMap.get(time).add((String) obj.get("_id"));
				}
			}
			end = System.currentTimeMillis();
			System.out.println("Successfully finish analysis, time totally：" + (end - start) + "ms");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		for(LinkedList<String> companyList: companyMap.values()) {
			Collections.sort(companyList);
		}

		for(LinkedList<String> timeList: timeMap.values()) {
			Collections.sort(timeList);
		}


	}
	public static void main(String[] args) {
		new JsonParse2();
	}

}


