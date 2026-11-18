public class Lance {
    private InteressadoLote autor;
    private double valor;

    public Lance(InteressadoLote autor, double valor){
        this.autor = autor;
        this.valor = valor;
    }

    public InteressadoLote getAutor(){ return this.autor; }

    public double getValor(){ return this.valor; }
}
