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
        //conn = new conectaDAO().connectDB();
    }
    
    public ArrayList<ProdutosDTO> listar(){
        return lista;
    }
}
