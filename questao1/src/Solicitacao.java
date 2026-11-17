public class Solicitacao {
    private String nomeAmbiente;
    private FabricaProvedor provedor;
    private int qtdMaquinas;
    private int gbArmazenamento;

    public Solicitacao(
        String nomeAmbiente, FabricaProvedor provedor, int qtdMaquinas, int gbArmazenamento
    ){
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.qtdMaquinas = qtdMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNomeAmbiente(){ return this.nomeAmbiente; }
    
    public FabricaProvedor getProvedor(){ return this.provedor; }

    public int getQtdMaquinas(){ return this.qtdMaquinas; }

    public int getGbArmazenamento(){ return this.gbArmazenamento; }
}
