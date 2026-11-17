// ProductB2
public class AzureArmazenamento implements Armazenamento{
    private final double custoGb = 0.02;
    private String id;
    private int gb;

    public AzureArmazenamento(String id, int gb){
        this.id = id;
        this.gb = gb;
    }

    public double getCustoGb() { return this.custoGb; }

    @Override
    public String getId(){ return this.id; }

    @Override
    public int getGb(){ return this.gb; }

    @Override
    public double getCustoMensal(){
        return this.gb * getCustoGb();
    }
}