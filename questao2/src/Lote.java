import java.util.ArrayList;

// ConcreteSubject (Observer) e Context (Strategy)
public class Lote {
    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;

    private ArrayList<Lance> lances = new ArrayList<>();
    private ArrayList<InteressadoLote> interessados = new ArrayList<>();

    private RegraComissao regraComissao;

    private boolean aberto = true;
    private boolean vendido = false;

    public Lote(
        String nome, String categoria, double precoInicial,
        double precoReserva, RegraComissao regraComissao
    ){
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    public String getNome(){ return this.nome; }
    public String getCategoria(){ return this.categoria; }
    public double getPrecoInicial(){ return this.precoInicial; }
    public double getLanceAtual(){ return this.lanceAtual; }
    public double getPrecoReserva(){ return this.precoReserva; }
    public int getTotalLances(){ return this.lances.size(); }
    public boolean isVendido(){ return this.vendido; }

    public void acompanhar(InteressadoLote interessado){
        this.interessados.add(interessado);
    }

    public void deixarDeAcompanhar(InteressadoLote interessado){
        this.interessados.remove(interessado);
    }

    private void notificarInteressados(Lance lance){
        for(InteressadoLote interessado : this.interessados){
            if(interessado != lance.getAutor()){
                interessado.atualizar(this, lance);
            }
        }
    }

    public void receberLance(InteressadoLote autor, double valor){
        if(!this.aberto){
            System.out.println("Lance recusado: o lote "
                + this.nome + " esta encerrado."
            );
            return;
        }

        double minimo = this.lanceAtual * 1.05;

        if(valor < minimo){
            System.out.println("Lance de R$" + valor
                + " recusado: precisa ser ao menos 5% maior"
                + " que R$" + this.lanceAtual
                + " (minimo R$" + minimo + ")."
            );
            return;
        }

        Lance lance = new Lance(autor, valor);
        this.lances.add(lance);
        this.lanceAtual = valor;

        this.notificarInteressados(lance);
    }

    public void encerrar(){
        this.aberto = false;

        if(this.lances.size() > 0 && this.lanceAtual >= this.precoReserva){
            this.vendido = true;
            System.out.println("Lote " + this.nome
                + " VENDIDO por R$" + this.lanceAtual
            );
        } else {
            this.vendido = false;
            System.out.println("Lote " + this.nome
                + " NAO VENDIDO - maior lance R$"
                + this.lanceAtual + " abaixo da reserva R$"
                + this.precoReserva
            );
        }
    }

    public void setRegraComissao(RegraComissao regraComissao){
        this.regraComissao = regraComissao;
    }

    public RegraComissao getRegraComissao(){ return this.regraComissao; }

    public void imprimirAcertoVendedor(){
        double comissao = this.regraComissao.calcular(this.lanceAtual);
        double liquido = this.lanceAtual - comissao;

        System.out.println("===== ACERTO DO VENDEDOR =====");
        System.out.println("Lote: " + this.nome);
        System.out.println("Valor de venda: R$" + this.lanceAtual);
        System.out.println("Regra de comissao: " + this.regraComissao.getNome());
        System.out.println("Comissao cobrada: R$" + comissao);
        System.out.println("Valor liquido ao vendedor: R$" + liquido);
    }
}