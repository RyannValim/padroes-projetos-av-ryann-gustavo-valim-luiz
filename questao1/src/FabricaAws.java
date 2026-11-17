// ConcreteFactory1
public class FabricaAws implements FabricaProvedor{
    private final double custoHoraVm = 0.10;
    private final double custoGbArmazenamento = 0.023;
    private final double custoFixoFila = 0.40;
    private int seqMaquina = 0;
    private int seqArmazenamento = 0;
    private int seqFila = 0;

    @Override
    public String getNome(){ return "Aws"; }

    @Override
    public double getCustoHoraVm(){ return this.custoHoraVm; }

    @Override
    public double getCustoGbArmazenamento(){ return this.custoGbArmazenamento; }

    @Override
    public double getCustoFixoFila(){ return this.custoFixoFila; }

    @Override
    public synchronized MaquinaVirtual criarMaquinaVirtual(){
        this.seqMaquina++;
        return new AwsMaquinaVirtual("i-" + this.seqMaquina);
    }

    @Override
    public synchronized Armazenamento criarArmazenamento(int gb){
        this.seqArmazenamento++;
        return new AwsArmazenamento("s3://" + this.seqArmazenamento, gb);
    }

    @Override
    public synchronized Fila criarFila(){
        this.seqFila++;
        return new AwsFila("sqs-" + this.seqFila);
    }
}
