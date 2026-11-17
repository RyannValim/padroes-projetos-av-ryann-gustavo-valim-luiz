import java.time.LocalDateTime;
import java.util.ArrayList;

// Singleton com double-checked locking
public class AuditoriaLog {
    private static volatile AuditoriaLog instancia;
    private ArrayList<String> registros = new ArrayList<>();
    
    private AuditoriaLog(){}

    public static AuditoriaLog getInstance(){
        if(instancia == null){
            synchronized (AuditoriaLog.class){
                if(instancia == null){
                    instancia = new AuditoriaLog();
                }
            }
        }

        return instancia;
    }

    public synchronized void registrar(String mensagem){
        String registro = LocalDateTime.now() + " - " + mensagem;

        this.registros.add(registro);
    }

    public synchronized void imprimirHistorico(){
        System.out.println("\n=== HISTÓRICO DE AUDITORIA ===");
        for(String registro : this.registros){
            System.out.println(registro);
        }
    }
}
