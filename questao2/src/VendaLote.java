// ConcreteComponent
public class VendaLote implements ItemFatura {

    private String nomeLote;
    private double valorVenda;

    public VendaLote(String nomeLote, double valorVenda){
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String getDescricao(){
        return "Lote: " + this.nomeLote + "\nValor de venda: R$" + this.valorVenda;
    }

    @Override
    public double getValor(){
        return this.valorVenda;
    }
}