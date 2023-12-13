package StudentGUI;

import java.util.StringTokenizer;


public class SinhVien{
	private String id, name, className;
	private float gpa;

	
	public SinhVien(String id, String name, String className, float gpa) {
		super();
		this.id = id;
		this.name = name;
		this.className = className;
		this.gpa = gpa;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public float getGpa() {
		return gpa;
	}


	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	
}
