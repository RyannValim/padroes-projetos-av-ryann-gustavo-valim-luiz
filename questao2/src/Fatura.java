public class Fatura {
    public void imprimir(ItemFatura item){
        System.out.println(item.getDescricao());
        System.out.println("TOTAL A PAGAR: R$" + item.getValor());
    }
}