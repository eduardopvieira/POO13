package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

public abstract class BaseDAOImpl<E> implements BaseDAO<E> {
    final static String URL = "jdbc:postgresql://localhost:5432/Oficina";
    final static String USER = "postgres";
    final static String PASS = "x3h912312";
    static Connection con = null;


    public static Connection getConnection() {
     
        if (con == null) {
     
            try{
                con = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conectado ao BD com sucesso");
            }catch (SQLException e) {

                e.printStackTrace();
                System.out.println("Falha ao conectar ao BD");
            }
            
      }
      return con;
}

    public static void closeConnection(){
        if (con != null) {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } con = null;
        }
    }

    public abstract Long inserir (E entity);

    public abstract void deletar (E entity);

    public abstract void alterar (E entity);

    public abstract ResultSet buscar (E entity);

    public abstract List<E> listar ();

}
