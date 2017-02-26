/*Sukwhan Youn
 */
  

import java.util.*;
import java.lang.*;

public class BinaryTree<Key>{
  //data fields
  private Key value;
  private BinaryTree<Key> parent;
  private BinaryTree<Key> left;
  private BinaryTree<Key> right;
  
  private BinaryTree<Key> root;
  public List<Key> preList = new ArrayList<Key>();
  public List<Key> inList = new ArrayList<Key>();
  public List<Key> postList = new ArrayList<Key>();
    
  //constructors
  public BinaryTree(){}
  
  public BinaryTree(Key key){
    value = key;
  }
  public BinaryTree(Key key, BinaryTree<Key> parent, BinaryTree<Key> left, BinaryTree<Key> right){
  value = key;
  parent = parent;
  left = left;
  right = right;
  }
  
  //methods
  public Key getData(){                     //return the value
    return value;
  }                  
   
  public BinaryTree<Key> getParent(){       //return the link to the parent
    return this.parent;
  }
  public BinaryTree<Key> getLeft(){         //return the link to the left child
    return this.left;
  }
  public BinaryTree<Key> getRight(){        //return the link to the right child
    return this.right;
  }
  public void setData(Key key){             //set the value to be key.
    this.value = key;
  }
  public void setParent(BinaryTree<Key> parent){    //set the parent link.
    this.parent = parent;
  }
  public void setLeft(BinaryTree<Key> left){        //set the left link. 
    this.left = left;
  }
  public void setRight(BinaryTree<Key> right){      //set the right link. 
    this.right = right;
  }
  public boolean isRoot(){       //return whether this binary tree(a node) is the root node or not.
    return this.parent==null;
  }
  public boolean isLeaf(){       //return whether this binary tree(a node) is a leaf node or not. 
    return this.left ==null && this.right ==null;
  }
  public int height(){           //return the height of this tree.
    int count = 0;
    BinaryTree<Key> temp = this;
    while (temp.left !=null){
      temp = temp.left;
      count++;
    }
    return count;
  }
  public int leafCount(){        //return the number of leaf nodes in this tree.
    if (this == null){
      System.out.println("Tree is empty");
      return 0;
    }
    else if (this.left == null && this.right == null){
      return 1;
    }
    return this.left.leafCount() + this.right.leafCount();
  }
  
  public List<Key> preOrder(BinaryTree<Key> root){   //return a List data type presenting the sequence of node keys when we traverse the tree Pre-Order.
    //List<Key> preList = new ArrayList<Key>();
    if (root!=null){
      preList.add(root.value);
      preOrder(root.left);
      preOrder(root.right);
    }
    return preList;  
  }
  
  public List<Key> inOrder(BinaryTree<Key> root){    //return a List data type presenting the sequence of node keys when we traverse the tree In-Order. 
    List<Key> inList = new ArrayList<Key>();
    if (root!=null){
      inOrder(parent.left);
      inList.add(parent.value);
      inOrder(parent.right);
    }
    return inList;
  }
  
  public List<Key> postOrder(BinaryTree<Key> root){  //return a List data type presenting the sequence of node keys when we traverse the tree Post-Order. 
    List<Key> postList = new ArrayList<Key>();
    if (root!=null){
      postOrder(parent.left);
      postList.add(parent.value);
      postOrder(parent.right);
    }
    return postList;
  }
  
  public int nodeSum(){          //return the sum of every node's value in the entire tree.
    if (this == null) return 0; //no node
    else if (this.left == null && this.right == null) return (Integer)this.value; //leaf node
    else return (Integer)this.value + this.left.nodeSum() + this.right.nodeSum();
  }
  
  public int maxPathSum(){       //path sum is the sum of values of nodes along a path(from the root node to a leaf node). Return the maximum path sum.
    if (this == null) return 0; //no node
    else if (this.left ==null && this.right ==null){
      return (Integer)this.value;
    }
    else return (Integer)this.value + Math.max(this.left.maxPathSum(), this.right.maxPathSum());
  }
//  
//    public int maxPathSum(){       //path sum is the sum of values of nodes along a path(from the root node to a leaf node). Return the maximum path sum.
//    if (this == null) return 0; //no node
//    else if (this.left ==null && this.right ==null){
//      Integer data = Integer.parseInt(this.value.toString());
//      return data;
//    }
//    else return Integer.parseInt(this.value.toString()) + Math.max(this.left.maxPathSum(), this.right.maxPathSum());
//  }
  public String toString(ArrayList<Key> b){  //Output as a String either the pre-order, in-order or post-order sequence of the nodes' value of the tree. 
    String result = "";
    for (int i=0;i<b.size();i++){
      result = result +""+ b.get(i);
    }
    return result;
  }

  
  public static void main(String[] args){
    BinaryTree<Integer> test1 = new BinaryTree<Integer>(16);
    BinaryTree test2 = new BinaryTree(4);
    BinaryTree test3 = new BinaryTree(8);
    BinaryTree test4 = new BinaryTree(3);
    BinaryTree test5 = new BinaryTree(1);
    BinaryTree test6 = new BinaryTree(7);
    BinaryTree test7 = new BinaryTree(5);
    
    test1.setLeft(test2);
    test1.setRight(test3);
    test2.setParent(test1);
    test3.setParent(test1);
    test2.setLeft(test4);
    test2.setRight(test5);
    test4.setParent(test2);
    test5.setParent(test2);
    test3.setLeft(test6);
    test3.setRight(test7);
    test6.setParent(test3);
    test7.setParent(test3);
    
    List<Integer> aList = test1.preOrder(test1);
    //test1.preList.clear();
    
    System.out.println("size of the binary tree is: " + aList.size());
    for (int i=0; i<aList.size(); i++){
      System.out.println(aList.get(i));
    }
    //test1.preList.clear();
    System.out.println("Sum of All nodes is: " + test1.nodeSum());
    System.out.println("Max Path Sum is: " + test1.maxPathSum());
    //int [] result = test1.preOrder(test1).toArray();
    //Arrays.toString(result);
    
    
  }
  
  
}
