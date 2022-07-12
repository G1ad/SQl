import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;


public class TableSQL {
    public static void main(String[] args){

        final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
        final String USER = "root";
        final String PASSWORD = "123";
        Connection con = null;

        try {
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection successful");

            Statement stm = con.createStatement();

            String studentsTable = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id INTEGER(10) NOT NULL AUTO_INCREMENT," +
                    "last_name VARCHAR(30)," +
                    "first_name VARCHAR(30)," +
                    "CONSTRAINT students_pk PRIMARY KEY (student_id)" +
                    ");";

            stm.executeUpdate(studentsTable);
            System.out.println("Table created");

            String firstStudent=  "INSERT INTO students (last_name, first_name) VALUES ('Rossi', 'Mario');";
            String secondStudent= "INSERT INTO students (last_name, first_name) VALUES ('Domenichi', 'Carlo');";
            String thirdStudent=  "INSERT INTO students (last_name, first_name) VALUES ('Sannino', 'Chiara');";
            String fourthStudent= "INSERT INTO students (last_name, first_name) VALUES ('Di Maio', 'Luigi');";

            stm.executeUpdate(firstStudent);
            stm.executeUpdate(secondStudent);
            stm.executeUpdate(thirdStudent);
            stm.executeUpdate(fourthStudent);

        } catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(con != null) con.close();
        }catch(SQLException o){
            System.out.println(o.getMessage());
        }
    }
}
}


