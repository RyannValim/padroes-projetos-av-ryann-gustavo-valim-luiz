import java.util.ArrayList;

public class Ambiente {
    private String nome;
    private String provedor;
    private ArrayList<MaquinaVirtual> maquinas;
    private Armazenamento armazenamento;
    private Fila fila;
    private double custoMensal;

    public Ambiente(
        String nome, String provedor, ArrayList<MaquinaVirtual> maquinas,
        Armazenamento armazenamento, Fila fila, double custoMensal
    ){
        this.nome = nome;
        this.provedor = provedor;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public void imprimirResumo(){
        System.out.println("\n=== AMBIENTE PROVISIONADO ===");
        System.out.println("Ambiente: " + this.nome);
        System.out.println("Provedor: " + this.provedor);

        String regiao = Configuracao.getInstance().getRegiaoPadrao();
        System.out.println("Região: " + regiao);
        
        for(MaquinaVirtual maquina : this.maquinas){
            System.out.println("Máquina Virtual: " + maquina.getId());
        }

        System.out.println("Armazenamento: " +
            this.armazenamento.getId() + " (" +
            this.armazenamento.getGb() + "GB)"
        );

        System.out.println("Fila: " + this.fila.getId());
        
        System.out.println("Custo mensal estimado: R$" + this.custoMensal);
    }
}
