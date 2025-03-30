import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutosDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    ArrayList<ProdutosDTO> lista = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        
        try{
            stmt = conn.prepareStatement("insert into produtos values (default,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2,produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar os produtos "+ex.getMessage());
        }finally{
            new conectaDAO().desconnectStmt(conn, stmt);
        }
    }
    
    public ArrayList<ProdutosDTO> listar(){
        conn = new conectaDAO().connectDB();
        
        try{
            stmt = conn.prepareStatement("select * from produtos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutosDTO p = new ProdutosDTO();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getInt("valor"));
                p.setStatus(rs.getString("status"));
                
                lista.add(p);
            }
            System.out.println("Produtos listados com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao listar os produtos "+ex.getMessage());
        }finally{
            new conectaDAO().desconnectRs(conn, stmt, rs);
        }
        
        return lista;
    }
    
    public void venderProduto (Integer id){
        conn = new conectaDAO().connectDB();
        
        try{
           stmt = conn.prepareStatement("select nome,status from produtos where id = ?");
           stmt.setInt(1, id);
           rs = stmt.executeQuery();
           
           if(rs.next()){
               String status = rs.getString("status");
               String nome = rs.getString("nome");
               
               if(status.equals("A Venda")){
                   status = "Vendido";
                   stmt = conn.prepareStatement("update produtos set status = ? where id = ?");
                   stmt.setString(1, status);
                   stmt.setInt(2, id);
                   stmt.executeUpdate();
                   
                   JOptionPane.showMessageDialog(null,nome+" foi vendido com sucesso!");
               }else{
                   JOptionPane.showMessageDialog(null,nome+" não está a venda");
               }
           }else{
               JOptionPane.showMessageDialog(null,"Registro não encontrado!");
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao encontrar registro: "+ex.getMessage());
        }finally{
            new conectaDAO().desconnectRs(conn,stmt,rs);
        }
    }
}
