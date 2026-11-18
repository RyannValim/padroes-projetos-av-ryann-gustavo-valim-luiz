//ConcreteStrategy
public class ComissaoVeiculos implements RegraComissao {
    private double limite = 5000.00;

    @Override
    public String getNome(){ return "Veiculos (8% limitado a R$5000)"; }

    @Override
    public double calcular(double valorVenda){
        double comissao = valorVenda * 0.08;

        if(comissao > this.limite){
            comissao = this.limite;
        }

        return comissao;
    }
}
