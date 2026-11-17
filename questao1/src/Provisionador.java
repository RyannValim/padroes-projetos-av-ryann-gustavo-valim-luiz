import java.util.ArrayList;

public class Provisionador {
    public Ambiente provisionar(Solicitacao solicitacao){
        FabricaProvedor fabrica = solicitacao.getProvedor();
        double orcamento = Configuracao.getInstance().getOrcamentoMaximo();

        double custo = (
            solicitacao.getQtdMaquinas()
            * fabrica.getCustoHoraVm() * 730
            + solicitacao.getGbArmazenamento()
            * fabrica.getCustoGbArmazenamento()
            + fabrica.getCustoFixoFila()
        );

        if(custo > orcamento){
            System.out.println("\n=== SOLICITACAO RECUSADA ===");
            System.out.println("Ambiente: " + solicitacao.getNomeAmbiente());
            System.out.println("Custo estimado R$" + custo + " acima do orcamento R$" + orcamento);

            AuditoriaLog.getInstance().registrar(
                solicitacao.getNomeAmbiente() + " - " + fabrica.getNome()
                + " | RECUSADO - custo estimado R$" + custo
                + " acima do orçamento de R$" + orcamento
            );

            return null;
        }

        ArrayList<MaquinaVirtual> maquinas = new ArrayList<>();
        for(int i = 0; i < solicitacao.getQtdMaquinas(); i++){
            maquinas.add(fabrica.criarMaquinaVirtual());
        }

        Armazenamento armazenamento = fabrica.criarArmazenamento(solicitacao.getGbArmazenamento());
        Fila fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(
            solicitacao.getNomeAmbiente(),
            fabrica.getNome(),
            maquinas, armazenamento,
            fila, custo
        );

        AuditoriaLog.getInstance().registrar(
            solicitacao.getNomeAmbiente() + " - "
            + fabrica.getNome() + " | ACEITO"
        );

        ambiente.imprimirResumo();

        return ambiente;
    }
}
