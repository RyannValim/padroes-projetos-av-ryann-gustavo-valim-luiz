// AbstractFactory
public interface FabricaProvedor {
    String getNome();
    double getCustoHoraVm();
    double getCustoGbArmazenamento();
    double getCustoFixoFila();
    MaquinaVirtual criarMaquinaVirtual();
    Armazenamento criarArmazenamento(int gb);
    Fila criarFila();
}
