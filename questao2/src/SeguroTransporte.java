// ConcreteDecorator
public class SeguroTransporte extends ServicoAdicional {
    private double valorVenda;

    public SeguroTransporte(ItemFatura item, double valorVenda){
        super(item);
        this.valorVenda = valorVenda;
    }

    private double getCusto(){
        return this.valorVenda * 0.015;
    }

    @Override
    public String getDescricao(){
        String mensagem = "\n- Seguro de transporte: R$";
        return this.item.getDescricao() + mensagem + this.getCusto();
    }

    @Override
    public double getValor(){
        return this.item.getValor() + this.getCusto();
    }
}