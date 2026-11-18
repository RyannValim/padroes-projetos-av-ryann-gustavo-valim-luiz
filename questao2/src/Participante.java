// ConcreteObserver
public class Participante implements InteressadoLote {
    private String nome;

    public Participante(String nome){
        this.nome = nome;
    }

    @Override
    public String getNome(){ return this.nome; }

    @Override
    public void atualizar(Lote lote, Lance lance){
        System.out.println("[" + this.nome + "] novo lance em "
            + lote.getNome() + ": R$" + lance.getValor()
        );
    }

    public void darLance(Lote lote, double valor){
        lote.receberLance(this, valor);
    }
}