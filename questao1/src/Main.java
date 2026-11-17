public class Main {
    public static void main(String[] args) throws InterruptedException{
        Provisionador provisionador = new Provisionador();

        FabricaProvedor aws = new FabricaAws();
        FabricaProvedor azure = new FabricaAzure();

        // solicitações
        Solicitacao solicitacao_aws_financeiro = new Solicitacao(
            "aws-financeiro", aws, 2, 500
        );
        Solicitacao solicitacao_aws_marketing = new Solicitacao(
            "aws-marketing", aws, 1, 200
        );

        // usando o "Thread" para conseguir demonstrar as threads em execução sem conflito
        // e utilizando as mesmas instâncias de singletons
        Thread thread1 = new Thread(() -> 
            provisionador.provisionar(solicitacao_aws_financeiro)
        );
        Thread thread2 = new Thread(() -> 
            provisionador.provisionar(solicitacao_aws_marketing)
        );

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        provisionador.provisionar(new Solicitacao(
            "azure-dados", azure, 3, 1000)
        );
        provisionador.provisionar(new Solicitacao(
            "aws-bigdata", aws, 20, 5000)
        );

        // log da auditoria
        AuditoriaLog.getInstance().imprimirHistorico();
    }
}
