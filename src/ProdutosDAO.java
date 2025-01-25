import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    
    public void cadastraarProduto (ProdutosDTO produto){
        //conn = new conectaDAO().connectDB();
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        return listagem;
    }
}
