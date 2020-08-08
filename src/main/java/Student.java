
public class Student {
	public int id = -1;
	public String name;
	public int age;
	
	public Student() {
		
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return id == -1
			? "Name: " + name + ", Age: " + age
			: "Id: " + id + ", Name: " + name + ", Age: " + age;
	}
}
