package MaquinaDeVendas;

public class TestMaquina {
    public static void main(String[] args) {
        MaquinaVenda vendas = new MaquinaVenda();
        vendas.cadastrarProduto("Banana", 1.20, 12);
        vendas.cadastrarProduto("limão", 1.50, 10);

        vendas.exibirEstoque();
        System.out.println("-----------------------");

        String produtoSelecionado = "Banana";
        if(vendas.selecionarProduto(produtoSelecionado)) {
            vendas.inserirDinheiro(10.00);
            double troco = vendas.comprarProduto(produtoSelecionado, 2);
            if(troco >= 0) {
                System.out.println("Troco: " + troco);
            }
        }


        vendas.exibirEstoque();

    }
}
