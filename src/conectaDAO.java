import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    public Connection connectDB(){
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection("");
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro conectaDAO "+ erro.getMessage());
        }
        
        return conn;
    }
}
