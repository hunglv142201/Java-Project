import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class StudentService {
	private Connection conn = null;
	
	public StudentService(Connection conn) {
		this.conn = conn;
	}
	
	public LinkedList<Student> getAll() throws SQLException {
		LinkedList<Student> students = new LinkedList<Student>();
		
		PreparedStatement ps = conn.prepareStatement(
				"SELECT * FROM STUDENTS_HUNG");
		ps.execute();
		
		ResultSet rs = ps.getResultSet();
		while (rs.next()) {
			students.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		}
		
		return students;
	}
	
	public void create(Student student) throws SQLException {
		if (student != null) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO STUDENTS_HUNG (NAME, AGE) "
					+ "VALUE (\"" + student.name +  "\", " + student.age + ")");
			ps.execute();
		}
	}
	
	public void update(Student student) throws SQLException {
		if (student != null) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE STUDENTS_HUNG "
					+ "SET NAME=\"" + student.name +  "\", AGE=" + student.age
					+ " WHERE ID=" + student.id);
			ps.execute();
		}
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"DELETE FROM STUDENTS_HUNG WHERE ID=" + id);
		ps.execute();
	}
}
