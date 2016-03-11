package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import createIndex.JsonParse2;


public class MyEngine {
	String indexFile; // the index file
//	Vector<String> vecKey = new Vector<String>();
	HashMap<String, String> hashWord = null;
	final int isOr = 0;
	final int isAnd = 1;
	long time = 0;
	int symbol = 0;
	HashMap<String, LinkedList<String>> companyMap = null;
	HashMap<String, LinkedList<String>> timeMap = null;
	
	public MyEngine() {
	}
	public MyEngine(String string) {
		JsonParse2 jp = new JsonParse2();
		this.companyMap = jp.getCompanyMap();
		this.timeMap = jp.getTimeMap();
	}
	public ArrayList<ResultModel> getResultSet(String key) {
		return null;
	}

	public static void main(String[] argv) {
		MyEngine index = new MyEngine("src/main/java/index.idx");
		ArrayList<ResultModel> testList = index.getResultSet("中国&美国");
		for(int i=0;i<testList.size();i++) {
			testList.get(i).printInfo();
			System.out.println(i);
		}

	}


}
