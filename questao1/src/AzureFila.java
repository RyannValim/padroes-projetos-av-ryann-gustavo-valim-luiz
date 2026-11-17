// ProductC2
public class AzureFila implements Fila{
    private final double custoFixo = 0.50;
    private String id;

    public AzureFila(String id){
        this.id = id;
    }

    public double getCustoFixo() { return this.custoFixo; }

    @Override
    public String getId(){ return this.id; }

    @Override
    public double getCustoMensal(){ return getCustoFixo(); }
}
