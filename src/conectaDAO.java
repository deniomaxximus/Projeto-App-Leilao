import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

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
            }
        }catch(SQLException ex){
            
        }
        
    }
    
    public void desconnecStm(PreparedStatement st){
        try{
            if(st != null){
                st.close();
            }
        }catch(SQLException ex){
            
        }
    }
}
