import java.time.LocalDateTime;

// ConcreteObserver
public class Auditor implements InteressadoLote {
    @Override
    public String getNome(){ return "Auditor"; }

    @Override
    public void atualizar(Lote lote, Lance lance){
        System.out.println("[AUDITOR] " + LocalDateTime.now()
            + " - lote " + lote.getNome()
            + " - " + lance.getAutor().getNome()
            + " - R$" + lance.getValor()
        );
    }
}
