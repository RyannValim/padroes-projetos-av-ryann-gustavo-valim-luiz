// ConcreteFactory2
public class FabricaAzure implements FabricaProvedor{
    private final double custoHoraVm = 0.12;
    private final double custoGbArmazenamento = 0.02;
    private final double custoFixoFila = 0.50;
    private int seqMaquina = 0;
    private int seqArmazenamento = 0;
    private int seqFila = 0;

    @Override
    public String getNome(){ return "Azure"; }

    @Override
    public double getCustoHoraVm(){ return this.custoHoraVm; }

    @Override
    public double getCustoGbArmazenamento(){ return this.custoGbArmazenamento; }

    @Override
    public double getCustoFixoFila(){ return this.custoFixoFila; }

    @Override
    public synchronized MaquinaVirtual criarMaquinaVirtual(){
        this.seqMaquina++;
        return new AzureMaquinaVirtual("vm-" + this.seqMaquina);
    }

    @Override
    public synchronized Armazenamento criarArmazenamento(int gb){
        this.seqArmazenamento++;
        return new AzureArmazenamento("blob://" + this.seqArmazenamento, gb);
    }

    @Override
    public synchronized Fila criarFila(){
        this.seqFila++;
        return new AzureFila("sb-" + this.seqFila);
    }
}
