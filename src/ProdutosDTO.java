
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProdutosDTO {
    
    private Integer id;
    private String nome;
    private Integer valor;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean verificaDado(JTextField txt, String tipo){
        boolean verificado = true;
        String dado = txt.getText();
        
        if(txt.getText().isEmpty()){
            verificado = false;
            JOptionPane.showMessageDialog(null, "O campo "+tipo+" deve ser preenchido");
        }else{
            switch(tipo){
                case "Valor":
                    if(dado.matches("\\d{1,}")){
                        verificado = true;
                    }else{
                        verificado = false;
                        JOptionPane.showMessageDialog(null,"Dados inválidos no campo "+tipo+"!");
                    }
                break;
            }
        }
        
        return verificado;
    }
}
