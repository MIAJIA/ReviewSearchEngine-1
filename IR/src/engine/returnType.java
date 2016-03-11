package engine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//Defination of returnType and how to read/write Object to file
public class returnType implements Serializable{
	returnType(){}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	private String _id;
	private String title;
	private int year;
	public static void main(String args[]) throws Exception {
		returnType test = new returnType();
		test.setYear(2016);
		test.set_id("ahd3456guyv");
		test.setTitle("Google");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tets.dat"));
		oos.writeObject(test);
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tets.dat"));
		returnType tRead = (returnType) ois.readObject();
		System.out.println(tRead._id + " " + tRead.title + " " + tRead.year);;
		
	}
}
