/*
    Nesta atividade o discente deverá criar uma aplicação em java, que gere uma
árvore de busca binária balanceada (AVL) orientada a objetos, em que o usuário
digite o número de elementos da árvore e a aplicação randomizará valores inteiros
para preenchimento dos elementos da árvore.

A árvore deverá permitir as seguintes operações:

    1. Incluir novo elemento (1 ponto) X

    2. Apagar um elemento existente (2,5 pontos)

    3. Buscar um elemento (1 ponto) X

    4. Imprimir a média dos valores armazenados na árvore (1 ponto) X

    5. Imprimir em ordem simétrica, pré-ordem e pós-ordem (1,5 ponto) X

    6. Imprimir a altura de um elemento (1 ponto)

    7. Imprimir a profundidade da árvore (1 ponto) X

    8. Implementar o método de balanceamento (1 ponto) X

 */
package com.mycompany.arvorebinariabusca;
import classes.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author brendoja
 */
public class arvoreBinariaBusca {
    
    
    public static void main(String[] args){
        BalancedTree tree = new BalancedTree();
        Scanner scan = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);
        BinaryTreePrinter tPrinter = new BinaryTreePrinter(tree.getRoot());
        List<Integer> aux = new ArrayList<>();
                
        boolean saida = true;
        @SuppressWarnings("UnusedAssignment")
        int op = 0;
        ps.println("ESSE PROGRAMA PERMITE CRIAR E ADMINISTRAR UMA ARVORE BALANCEADA"
                + " DO TIPO AVL");
        do{
            ps.println("-------------------------------------------------------\n"+
                    " - Escolha uma opção abaixo: \n"+
                    "0. Criar nova arvore aleatoria\n" +
                    "1. Incluir novo elemento \n" +
                    "2. Apagar um elemento existente \n" +
                    "3. Buscar um elemento \n" +
                    "4. Imprimir a média dos valores armazenados na árvore \n" +
                    "5. Imprimir em ordem simétrica, pré-ordem e pós-ordem \n" +
                    "6. Imprimir a altura de um elemento \n" +
                    "7. Imprimir a profundidade da árvore \n" +
                    "9. SAIR \n"+ 
                    "--------------------------------------------------------");
            op = scan.nextInt();
            switch(op){
                case 0 -> {
                    //0. Criar uma nova arvore e, se existir, apagar a atual
                    
                    ps.println("escreva um tamanho para sua arvore: ");
                    int nums = scan.nextInt();
                    Random rand = new Random();
                    if(tree.getRoot() != null){
                        tree.clear(rand.nextInt(9999));
                        for(int i = 0; i < nums - 1; i++){
                            try{
                                tree.add(rand.nextInt(9999));
                            }catch (Exception e){
                                i--;
                            }
                        }
                    }else{
                        for(int i = 0; i < nums; i++){
                            try{
                                tree.add(rand.nextInt(9999));
                            }catch (Exception e){
                                i--;
                            }
                        }
                    }
                
                    ps.println("Sua arvore foi criada com os seguintes valores: ");
                    //imprime na ordem
                    
                    tPrinter.print(ps, tree.getRoot());
                  
                    ps.println("\ndeseja continuar? y/n");
                    saida = scan.next().equals("y");
                }
                    
                case 1 -> {
                    //1. Incluir novo elemento
                    ps.println("introduza um numero inteiro que para inserir na"
                            + " arvore");
                    int num = scan.nextInt();
                    try{
                        tree.add(num);
                        ps.printf("Item %d inserido ", num);
                        
                    }catch(Exception e){
                        ps.print(e);
                    }
                    scan.nextLine();
                    ps.println("deseja ver a arvore: y?");
                    String s = scan.nextLine();
                    if (s.equals("y")) {
                        ps.println("sua arvore agora está assim: ");
                        tPrinter.print(ps, tree.getRoot());
                        
                        ps.println("\ndeseja continuar? y/n");
                        saida = scan.next().equals("y");
                    } else {
                        ps.println("\ndeseja continuar? y/n");
                        saida = scan.next().equals("y");
                    }
                }
                    
                case 2 -> {
                    //2. Apagar um elemento existente
                    scan.nextLine();
                    ps.println("sua arvore está assim: ");
                    tPrinter.print(ps, tree.getRoot());
                    ps.println("\nqual elemento você desenha remover? ");
                    try{
                        tree.remove(scan.nextInt());
                    }catch(Exception e){
                        ps.println("Valor nao encontrado"+e);
                        break;
                    }
                    ps.println("Nova arvore: ");
                    tPrinter.print(ps, tree.getRoot());
                    
                    ps.println("\ndeseja continuar? y/n");
                    saida = scan.next().equals("y");
                }
                    
                case 3 -> {
                    //3. Buscar um elemento
                    scan.nextLine();
                    ps.println("Qual elemento da arvore você deseja ver? (escreva"
                            + " seu valor)");
                    tPrinter.print(ps, tree.getRoot());
                    ps.println("\n");
                    int trg = scan.nextInt();
                    try{
                        Node n = tree.search(trg);
                        n = tree.rebalance(n);
                        tPrinter.print(ps, n);                        
                    }catch (Exception e){
                        ps.println("Item não encontrado");
                        break;
                    }
                    ps.println("\ndeseja continuar? y/n");
                    saida = scan.next().equals("y");
                }
                    
                case 4 -> {
                    //4. Imprimir a média dos valores armazenados na árvore
                    Integer[] listFromTree = tree.inOrder(tree.getRoot(), aux);
                    int media = 0;
                    for (Integer listFromTree1 : listFromTree) {
                        media += listFromTree1;
                    }
                    media = media/listFromTree.length;
                    ps.println("A media da arvore é: \n"+media);
                    
                    ps.println("\ndeseja continuar? y/n");
                    saida = scan.next().equals("y");
                }

                    
                case 5 -> {
                    //5. Imprimir em ordem simétrica, pré-ordem e pós-ordem
                    ps.println("\nimprimindo em ordem simetrica");
                    ps.println(Arrays.toString(tree.inOrder(tree.getRoot(),
                            new ArrayList<Integer>())));
                    ps.println("\nimprimindo em pré-ordem");
                    ps.println(Arrays.toString(tree.beforeOrder(tree.getRoot(),
                            new ArrayList<Integer>())));
                    ps.println("\nimprimindo em pós-ordem");
                    ps.println(Arrays.toString(tree.afterOrder(tree.getRoot(),
                            new ArrayList<Integer>())));
                    
                    ps.println("\ndeseja continuar? y/n");
                    saida = scan.next().equals("y");
                }

                case 6 -> {
                    //6. Imprimir a altura de um elemento
                    scan.nextLine();
                    ps.println("Qual elemento da arvote você deseja saber a altura?");
                    tPrinter.print(ps, tree.getRoot());
                    ps.println("\n");
                    Node target = tree.search(scan.nextInt());
                    
                    ps.printf("\na altura do elemento %d é %d e essa é sua sub-arvore: \n"
                            , target.getValue(), tree.height(target));
                    tPrinter.print(ps, target);
                    
                    ps.println("\ndeseja continuar? y/n");
                    saida = scan.next().equals("y");
                }
                    
                case 7 -> {
                    //7. Imprimir a profundidade da árvore
                    ps.println("a profundidade da sau arvore é: "+tree.height(
                            tree.getRoot()));
                    
                    ps.println("\ndeseja continuar? y/n");
                    saida = scan.next().equals("y");
                }
                    
                case 9 -> //9. sair do programa
                    saida = false;
            }
            scan.nextLine();
        }while(saida);

     }
    
}
