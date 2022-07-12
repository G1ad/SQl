import java.sql.*;
public class AlterSQL {
    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
        final String USER = "root";
        final String PASSWORD = "123";
        Connection con = null;

        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("Connected to the Database\n");
            System.out.println("Adding data to the column...");
            //adding country column to the students table in newdb
            Statement stm = con.createStatement();
            String query1 = "ALTER TABLE students " +
                             "ADD COLUMN country VARCHAR(30);";
            stm.executeUpdate(query1);
            System.out.println("Country column added to the table");
            //adding Italy data to the first and second student
            String query2 = "UPDATE students " +
                            "SET country = 'Italy' WHERE student_id in (1, 2)";
            stm.executeUpdate(query2);
            //adding Germany data to the third and fourth student
            String query3 = "UPDATE students " +
                            "SET country = 'Germany' WHERE student_id in (3, 4)";
            stm.executeUpdate(query3);
            System.out.println("Done!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
