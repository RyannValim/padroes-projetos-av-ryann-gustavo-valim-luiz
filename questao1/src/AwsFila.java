// ProductC1
public class AwsFila implements Fila{
    private final double custoFixo = 0.40;
    private String id;

    public AwsFila(String id){
        this.id = id;
    }

    public double getCustoFixo() { return this.custoFixo; }

    @Override
    public String getId(){ return this.id; }

    @Override
    public double getCustoMensal(){ return getCustoFixo(); }
}
