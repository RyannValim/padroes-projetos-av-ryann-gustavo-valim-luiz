// ConcreteStrategy
public class ComissaoArte implements RegraComissao {
    @Override
    public String getNome(){ return "Arte (20%)"; }

    @Override
    public double calcular(double valorVenda){
        return valorVenda * 0.20;
    }
}
