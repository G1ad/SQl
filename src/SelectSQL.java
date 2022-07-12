import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 class SelectSQL {
    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
        final String USER = "root";
        final String PASSWORD = "123";

        Connection con = null;
        List<String> surnames = new ArrayList<>();

        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("Connected to the Database\n");

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM students");

            System.out.println("Printing students surnames:");
            while(rs.next()){
                //adding surnames to the ArrayList
                surnames.add(rs.getString("last_name"));
            }
            //printing the surnames of students from surnames ArrayList
            System.out.println(Arrays.toString(surnames.toArray())+"\n");

        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                System.out.println("Closed connection to the Database");
            } catch (SQLException o) {
                o.printStackTrace();}
        }
    }
 }
