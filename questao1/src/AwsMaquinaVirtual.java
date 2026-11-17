// ProductA1
public class AwsMaquinaVirtual implements MaquinaVirtual{
    private final double custoHora = 0.10;
    private String id;

    public AwsMaquinaVirtual(String id){
        this.id = id;
    }

    public double getCustoHora() { return this.custoHora; }

    @Override
    public String getId(){ return id; }

    @Override
    public double getCustoMensal(){
        return getCustoHora() * 730;
    }
}
