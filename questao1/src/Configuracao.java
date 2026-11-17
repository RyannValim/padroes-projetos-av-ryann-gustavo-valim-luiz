// Singleton com holder
public class Configuracao {
    private String regiaoPadrao = "sa-east-1";
    private double orcamentoMaximo = 500.00;

    private Configuracao(){}

    private static class ConfiguracaoHolder{
        private static final Configuracao instancia = new Configuracao();
    }

    public static Configuracao getInstance(){ return ConfiguracaoHolder.instancia; }

    public String getRegiaoPadrao(){ return this.regiaoPadrao; }

    public double getOrcamentoMaximo(){ return this.orcamentoMaximo; }
}
