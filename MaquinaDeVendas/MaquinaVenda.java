package MaquinaDeVendas;

import java.util.ArrayList;
import java.util.List;

public class MaquinaVenda {
    List<Produto> produtos;
    double dinheiroInserido;

    MaquinaVenda() {
        produtos = new ArrayList<>();
        dinheiroInserido = 0.0;
    }

    public void cadastrarProduto(String nomeProduto, double preco, int quantidade) {
          produtos.add(new Produto(nomeProduto, preco, quantidade));
    }
    public void exibirEstoque() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    public boolean selecionarProduto(String nomeProduto) {
        for(Produto produto : produtos) {
            if(nomeProduto.equalsIgnoreCase(produto.getNomeProduto())) {
                if(produto.getQuantidade() > 0) {
                    System.out.println("MaquinaDeVendas.Produto selecionado: " + produto.getNomeProduto());
                    return true;
                } else {
                    System.out.println("MaquinaDeVendas.Produto fora do estoque");
                    return false;
                }
            }
        }
        System.out.println("MaquinaDeVendas.Produto não encontrado");
        return false;
    }
    public void inserirDinheiro(double valor) {
        if(valor > 0) {
            dinheiroInserido += valor;
            System.out.println("Dinheiro inserido com sucesso");
        } else {
            System.out.println("Tente novamente!");
        }

    }
    public double comprarProduto(String nomeProduto, int qtd) {
        for (Produto produto : produtos) {
            if(selecionarProduto(nomeProduto)) {
                if (dinheiroInserido >= produto.getPreco()) {
                    double valorProduto = qtd * produto.getPreco();
                    if (valorProduto <= dinheiroInserido) {
                        double troco = dinheiroInserido - valorProduto;
                        produto.vendido(qtd);
                        System.out.println("Compra realizada com sucesso");
                        return troco;
                    } else {
                        System.out.println("Compra final não aprovada");
                        return -1;
                    }
                } else {
                    System.out.println("Dinheiro insuficiente!");
                    return -1;
                }
            }
        }
        return -1;
    }

}
