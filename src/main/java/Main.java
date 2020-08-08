import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(  
				"jdbc:mysql://shoponline.ckculqcubfxc.ap-southeast-1.rds.amazonaws.com/shop","admin","12345678");
		
		StudentService stdService = new StudentService(conn);
		
//		stdService.create(new Student("Hue", 60));
		
//		stdService.update(new Student(2, "Test", 12));
		
//		stdService.delete(3);
		
		LinkedList<Student> students = stdService.getAll();
		
		for (Student std : students) {
			System.out.println(std);
		}
	}

}
