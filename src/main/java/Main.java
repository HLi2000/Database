import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        }
        catch (Exception e) {
        }
        Connection conn= DriverManager.getConnection(dbUrl, "postgres", "13701192215");

        try {
            Statement s=conn.createStatement();
            String sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (2,3);";
            s.execute(sqlStr);
            sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (3,3);";
            s.execute(sqlStr);
            s.close();
            //conn.close();
        }
        catch (Exception e){ }

        try {
            Statement s=conn.createStatement();
            String sqlStr = "SELECT * FROM patients WHERE id>1;";
            ResultSet rset=s.executeQuery(sqlStr);
            while(rset.next()){
                System.out.println(rset.getInt("id")+" "+ rset.getString("familyname"));
            }
            rset.close();
            s.close();
            conn.close();
        }
        catch (Exception e){
        }
    }
}
