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
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    
    public void cadastrarProduto (ProdutosDTO produto){
        conectaDAO conector = new conectaDAO();
        
        conn = conector.connectDB();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("insert into produtos values (default,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2,produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Cadastrados com sucesso", "Dados Salvos", 1);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no cadastro "+ex.getMessage(), "Dados Salvos", 0);
        }finally{
            conector.desconnecStm(stmt);
            conector.desconnectDB(conn);
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        return listagem;
    }
}
