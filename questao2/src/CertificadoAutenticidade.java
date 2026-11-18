// ConcreteDecorator
public class CertificadoAutenticidade extends ServicoAdicional {
    private double custo = 300.00;

    public CertificadoAutenticidade(ItemFatura item){
        super(item);
    }

    @Override
    public String getDescricao(){
        String mensagem = "\n- Certificado de autenticidade: R$";
        return this.item.getDescricao() + mensagem + this.custo;
    }

    @Override
    public double getValor(){
        return this.item.getValor() + this.custo;
    }
}
