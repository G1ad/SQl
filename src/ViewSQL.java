import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ViewSQL {
    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
        final String USER = "root";
        final String PASSWORD = "123";
        Connection con = null;
        List<Student> italianStudents = new ArrayList<>();
        List<Student> germanStudents  = new ArrayList<>();

        try {
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection successful");
            Statement stm = con.createStatement();

            // //creating view for italian_students and german_students
            String setViewItaly = "CREATE VIEW italian_students AS (SELECT * from students WHERE country = 'Italy');";
            stm.executeUpdate(setViewItaly);
            System.out.println("---------------------");
            System.out.println("View created for italian students");

            String setView2 = "CREATE VIEW german_students AS (SELECT * from students WHERE country = 'Germany');";
            stm.executeUpdate(setView2);
            System.out.println("View created for german students");

            ResultSet rs1 = stm.executeQuery("SELECT * FROM italian_students");
            //adding italian_students to his own ArrayList
            while(rs1.next()){
                italianStudents.add(new Student(rs1.getString("first_name"), rs1.getString("last_name")));
            }
            ResultSet rs2 = stm.executeQuery("SELECT * FROM german_students;");
            //adding german students to his own ArrayList
            while(rs2.next()){
                germanStudents.add(new Student(rs2.getString("first_name"), rs2.getString("last_name")));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("--------------------------------");
        System.out.println("All surnames from arrayList 'italian_students':");
        System.out.println(italianStudents+"\n");

        System.out.println("All surnames from arrayList 'german_students':");
        System.out.println(germanStudents);

    }

}

