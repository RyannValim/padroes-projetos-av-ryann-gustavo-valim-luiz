// ProductB1
public class AwsArmazenamento implements Armazenamento{
    private final double custoGb = 0.023;
    private String id;
    private int gb;

    public AwsArmazenamento(String id, int gb){
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
