// concreteDecorator
public class EmbalagemEspecial extends ServicoAdicional {
    private double custo = 180.00;

    public EmbalagemEspecial(ItemFatura item){
        super(item);
    }

    @Override
    public String getDescricao(){
        String mensagem = "\n- Embalagem especial: R$";
        return this.item.getDescricao() + mensagem + this.custo;
    }

    @Override
    public double getValor(){
        return this.item.getValor() + this.custo;
    }
}
