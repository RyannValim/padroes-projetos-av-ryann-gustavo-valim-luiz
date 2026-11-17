// ProductA2
public class AzureMaquinaVirtual implements MaquinaVirtual{
    private final double custoHora = 0.12;
    private String id;

    public AzureMaquinaVirtual(String id){
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
