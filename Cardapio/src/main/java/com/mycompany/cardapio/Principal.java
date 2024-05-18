package com.mycompany.cardapio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
// Sistema de ArrayList sem espaço delimitado, como visto na aula do dia 14
    private static ArrayList<Produto> produtos = new ArrayList<>();
//Metodo main e menu
    public static void main(String[] args) {
        cadastrarProdutosIniciais();
        menu();
    }
// Cadastro dos produtos com 5 categorias exigidas no trabalho, produtos ja determinados na abertura do programa
    private static void cadastrarProdutosIniciais() {
        produtos.add(new Produto("Hamburguer", "Comida", 15.99, 50, "Hamburguer artesanal com queijo"));
        produtos.add(new Produto("Pizza", "Comida", 39.99, 20, "Pizza de mussarela"));
        produtos.add(new Produto("Refrigerante", "Bebida", 4.50, 100, "Refrigerante de cola"));
        produtos.add(new Produto("Suco Natural", "Bebida", 6.00, 80, "Suco de laranja natural"));
        produtos.add(new Produto("Salada", "Comida", 12.50, 30, "Salada fresca com molho especial"));
        produtos.add(new Produto("Sorvete", "Sobremesa", 7.99, 60, "Sorvete de chocolate"));
        produtos.add(new Produto("Bolo", "Sobremesa", 8.99, 40, "Bolo de cenoura com cobertura de chocolate"));
    }
//Interaçao com o usuario com looping e tratamentos de erro finalizado
    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Buscar produto por nome");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opcao: ");

            
                try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        cadastrarProduto(scanner);
                        break;
                    case 2:
                        listarProdutos();
                        break;
                    case 3:
                        buscarProduto(scanner);
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção invalida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida! Por favor, insira um numero.");
                scanner.nextLine(); 
            }
        }
    }
//opçao de cadastro com as mesmas categorias do que ja estava cadastrado no programa logo aberto(ja com tratamento de erros finalizado)
    private static void cadastrarProduto(Scanner scanner) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Categoria: ");
            String categoria = scanner.nextLine();
            System.out.print("Preco: ");
            double preco = scanner.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Descricao: ");
            String descricao = scanner.nextLine();

            produtos.add(new Produto(nome, categoria, preco, quantidade, descricao));
            System.out.println("Produto cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida! O cadastro foi cancelado.");
            scanner.nextLine();  
        }
    }
// listagem ja tabulada e alterada
    private static void listarProdutos() {
        System.out.printf("%-20s %-15s %-10s %-10s %-30s%n", "Nome", "Categoria", "Preco", "Quantidade", "Descricao");
        for (Produto produto : produtos) {
            System.out.printf("%-20s %-15s %-10.2f %-10d %-30s%n", 
                              produto.getNome(), produto.getCategoria(), produto.getPreco(), produto.getQuantidade(), produto.getDescricao());
        }
    }
//sistema de busca de produto com estrutura de condicional if para margem de erro de nao achar o produto digitado
    private static void buscarProduto(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println(produto);
                return;
            }
        }

        System.out.println("Produto nao encontrado.");
    }
}

