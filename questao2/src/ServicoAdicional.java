// Decorator
public abstract class ServicoAdicional implements ItemFatura {
    protected ItemFatura item;

    public ServicoAdicional(ItemFatura item){
        this.item = item;
    }
}
