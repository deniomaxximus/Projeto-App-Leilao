import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutosDAO {
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;
    ArrayList<ProdutosDTO> lista = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("insert into produtos values (default,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2,produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.executeUpdate();
            
            System.out.println("Dados cadastrados");
        }catch(SQLException ex){
            System.out.println("Dados não salvos");
        }finally{
            new conectaDAO().desconnectStmt(conn, stmt);
        }
    }
    
    public ArrayList<ProdutosDTO> listar(){
        return lista;
    }
}
