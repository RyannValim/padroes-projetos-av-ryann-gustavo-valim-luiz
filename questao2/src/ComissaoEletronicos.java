// ConcreteStrategy
public class ComissaoEletronicos implements RegraComissao {
    private double minimo = 50.00;

    @Override
    public String getNome(){ return "Eletronicos (12% com minimo de R$50)"; }

    @Override
    public double calcular(double valorVenda){
        double comissao = valorVenda * 0.12;

        if(comissao < this.minimo){
            comissao = this.minimo;
        }

        return comissao;
    }
}
