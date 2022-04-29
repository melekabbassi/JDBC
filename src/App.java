import java.sql.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException  {
       
        Connection cnx=null;
        Statement st=null;
        try {
        //chargement du pilote
        Class.forName("com.mysql.jdbc.Driver");
        //connection a la base de données
        System.out.println("connexion a la base de données");
        cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_netbeans?characterEncoding=utf8", "root", "");
        String requete1 = "INSERT INTO person VALUES (123,'Ahmed')";
        String requete2 = "INSERT INTO person VALUES (456,'Ali')";
        st = cnx.createStatement();
           int nb1 = st.executeUpdate(requete1);
           int nb2 = st.executeUpdate(requete2);
           System.out.println("nb mise a jour = "+(nb1+nb2));
         ResultSet res = st.executeQuery("select * from person");
          while (res.next()) 
          { 
          int id = res.getInt("id") ; 
          String name = res.getString("name") ;
          System.out.println(id+name);
           }
          
        }catch (SQLException e)
        {
            System.out.println(e);
        }
      }
}