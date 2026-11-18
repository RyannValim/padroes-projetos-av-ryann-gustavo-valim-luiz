// ConcreteStrategy
public class ComissaoImoveis implements RegraComissao {
    private double taxaFixa = 1500.00;

    @Override
    public String getNome(){ return "Imoveis (3% + R$1500)"; }

    @Override
    public double calcular(double valorVenda){
        return (valorVenda * 0.03) + this.taxaFixa;
    }
}
