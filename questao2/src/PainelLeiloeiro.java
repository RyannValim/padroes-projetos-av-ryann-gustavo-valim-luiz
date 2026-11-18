// ConcreteObserver
public class PainelLeiloeiro implements InteressadoLote {
    @Override
    public String getNome(){ return "Painel do Leiloeiro"; }

    @Override
    public void atualizar(Lote lote, Lance lance){
        System.out.println("[PAINEL] " + lote.getNome()
            + " - maior lance: R$" + lote.getLanceAtual()
            + " | total de lances: " + lote.getTotalLances()
        );
    }
}