// ConcreteDecorator
public class EntregaExpressa extends ServicoAdicional {
    private double custo = 450.00;

    public EntregaExpressa(ItemFatura item){
        super(item);
    }

    @Override
    public String getDescricao(){
        String mensagem = "\n- Entrega expressa: R$";
        return this.item.getDescricao() + mensagem + this.custo;
    }

    @Override
    public double getValor(){
        return this.item.getValor() + this.custo;
    }
}