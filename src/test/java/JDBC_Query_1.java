import java.sql.*;

public class JDBC_Query_1 {

    public static void main(String[] args) throws SQLException {

        //1-> Kullanilacak veritabanı icin dogru suruvuyu ekle

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }
        // 2-> Database baglantısı kurulur


        Connection con = DriverManager.getConnection("jdbc:mysql://194.140.198.209/heallife_hospitaltraining",
                                                   "heallife_hospitaltraininguser",
                                                         "PI2ZJx@9m^)3");
        // Olusturulan conenction bir objeye atanmasa da calisir
        // ancak ilerde ilgili connection'i kullanmak istersek ona ulasamayiz.
        // O yuzden onu Connection nesnesine atama yapariz.



        // 3-> SQL sorgularini yapabilmek icin suite hazirla

        Statement st =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // 4-> SQL ifadeleri olustur ve calistir

        String query="SELECT * FROM heallife_hospitaltraining.staff";
        ResultSet rs = st.executeQuery(query);

        rs.next();// iterator kurduk
        System.out.println(rs.getString("name"));

    }
}
