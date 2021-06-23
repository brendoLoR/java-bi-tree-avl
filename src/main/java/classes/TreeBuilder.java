/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author brendoja
 */
public class TreeBuilder {
    private Node root;

    public Node insert(int value){
        Node node = new Node(value);
        if(this.isEmpyt()){
            this.setRoot(node);
            return getRoot();
        }else{
            this.add(node, root);
            return node;
        }        
    }
    public void add(Node node, Node root){
        if(node.getValue() <= root.getValue()){
            // verifica se a esquerda está vazio
            if(root.getLeft() == null){
                root.setLeft(node);
            }else{
                this.add(node, root.getLeft());
            }
        }else{
            if(root.getRight() == null){
                root.setRight(node);
            }else{
                this.add(node, root.getRight());
            }
        } 
    }
    public void inOrder(Node node){
        if(node != null){
            this.inOrder(node.getLeft());
            System.out.print(node.getValue()+ "   ");
            this.inOrder(node.getRight());
        }
    }
    public void beforeOrder(Node node){
        if(node != null){
            System.out.print(node.getValue()+ "   ");
            this.inOrder(node.getLeft());
            this.inOrder(node.getRight());
        }
    }
    public void afterOrder(Node node){
        if(node != null){
            this.inOrder(node.getLeft());
            this.inOrder(node.getRight());
            System.out.print(node.getValue()+ "   ");

        }
    }
    public boolean isEmpyt(){
        return this.root == null;
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public void leftRotate(Node root){
        Node leftNode = root.getLeft();
        Node granLeftNode = leftNode.getRight();
        leftNode.setRight(root);
        root.setLeft(granLeftNode);
    }

}
