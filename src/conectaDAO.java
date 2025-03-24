import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class conectaDAO {
    Connection conn;
    private String url = "jdbc:mysql://localhost:3306/banco_leilao";
    private String user = "root";
    private String password = "bzjeie01";
    
    public Connection connectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão realizada com sucesso");
            
        }catch(ClassNotFoundException | SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados "+ erro.getMessage());
            conn = null;
        }
        
        return conn;
    }
    
    public void desconnectDB(Connection c){
        try{
            if(c != null){
                c.close();
                System.out.println("Banco desconectado");
            }
        }catch(SQLException ex){
            
        }
        
    }
    
    public void desconnectStmt(Connection con, PreparedStatement st){
        try{
            if(st != null){
                st.close();
                
                System.out.println("Statement fechado");
            }
        }catch(SQLException ex){
            
        }
        
        desconnectDB(con);
    }
    
    public void desconnectRs(Connection con, PreparedStatement st, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
                System.out.println("Result set fechado");
            }
        }catch(SQLException ex){
            
        }
        
        desconnectStmt(con,st);
    }
}
