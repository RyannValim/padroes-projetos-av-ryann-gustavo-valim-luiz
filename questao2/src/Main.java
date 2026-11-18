public class Main {
    public static void main(String[] args){
        Participante ryann = new Participante("Ryann");
        Participante lucas = new Participante("Lucas");
        Participante gabriel = new Participante("Gabriel");

        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        Lote quadro = new Lote("Quadro Girassóis", "Arte", 10000.00, 12000.00, new ComissaoArte());

        quadro.acompanhar(ryann);
        quadro.acompanhar(lucas);
        quadro.acompanhar(gabriel);
        quadro.acompanhar(painel);
        quadro.acompanhar(auditor);

        System.out.println("----- LANCES NO LOTE 1 -----");
        ryann.darLance(quadro, 10500.00);
        lucas.darLance(quadro, 10700.00);
        lucas.darLance(quadro, 11100.00);

        System.out.println("\n----- GABRIEL DEIXA DE ACOMPANHAR -----");
        quadro.deixarDeAcompanhar(gabriel);

        ryann.darLance(quadro, 12000.00);

        System.out.println("\n----- CAMPANHA: TROCA DA REGRA DE COMISSÃO -----");
        quadro.setRegraComissao(new ComissaoEletronicos());

        System.out.println("\n----- ENCERRAMENTO DO LOTE 1 -----");
        quadro.encerrar();
        quadro.imprimirAcertoVendedor();

        System.out.println("\n----- FATURA DO COMPRADOR -----");
        ItemFatura compra = new VendaLote(quadro.getNome(), quadro.getLanceAtual());
        compra = new SeguroTransporte(compra, quadro.getLanceAtual());
        compra = new CertificadoAutenticidade(compra);
        compra = new EntregaExpressa(compra);
        compra = new EntregaExpressa(compra);

        Fatura fatura = new Fatura();
        fatura.imprimir(compra);

        Lote fusca = new Lote("Fusca 1972", "Veículos", 20000.00, 35000.00, new ComissaoVeiculos());

        fusca.acompanhar(ryann);
        fusca.acompanhar(lucas);
        fusca.acompanhar(painel);
        fusca.acompanhar(auditor);

        System.out.println("\n----- LANCES NO LOTE 2 -----");
        lucas.darLance(fusca, 21000.00);
        gabriel.darLance(fusca, 21500.00);
        gabriel.darLance(fusca, 23000.00);

        System.out.println("\n----- ENCERRAMENTO DO LOTE 2 -----");
        fusca.encerrar();

        ryann.darLance(fusca, 40000.00);
    }
}