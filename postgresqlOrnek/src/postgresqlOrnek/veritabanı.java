package postgresqlOrnek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class veritabanı {
	static String url = "jdbc:postgresql://localhost:5432/deneme";
	static Connection conn =null;
	
	
	
	
	
	
	
	public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/deneme";
        String user = "root";
        String password = "5432";

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url,user,password);

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO "
                    + "kisiler(kisi_adi, kisi_soyadi) "
                    + "VALUES('Emirhan', 'Doğandemir')";

            System.out.println(statement.executeUpdate(sql) + " kayıt eklendi.");

            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
    }
	
	
	
	
	
	
	
	
	
	static void baglan(){
		try {
			conn = DriverManager.getConnection(url,"postgres","12345");
			System.out.println("Bağlantı gerçekleştirildi.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static ResultSet listele(String sorgu) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	static ResultSet ekle(String sorgu) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
