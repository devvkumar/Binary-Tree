import java.util.LinkedList;
import java.util.Queue;

public class BinnaryTree {
//    Creating Node
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binnaryTree{
        static int idx = -1;
        public static Node buidTree(int[] node){
            idx++;
            if (node[idx] == -1){
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buidTree(node);
            newNode.right = buidTree(node);
            return newNode;

        }
    }

//    PreOrder Traversal

    public static void preOrder(Node root){
        if (root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }

//    PostOrder Traversal
    public static void postOrder(Node root){
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");

    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int countofNode(Node root){
        if (root == null){
            return 0;
        }
        int leftNode = countofNode(root.left);
        int rightNode = countofNode(root.right);

        return leftNode + rightNode + 1;

    }

//    Sum of Node
    public static int sumofNode(Node root){
        if (root == null){
            return 0;
        }

        int leftSum = sumofNode(root.left);
        int rightSum = sumofNode(root.right);

        return leftSum + rightSum + root.data;

    }

//    Height of Node
    public static int height(Node root){
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int myHeight = Math.max(leftHeight , rightHeight ) +1;
        return myHeight;

    }

//    Diameter of Tree
//    APPROCH 1 :
    public static int diameter(Node root){
        if (root == null){
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;
        int myHeight = Math.max(diam3 , Math.max(diam1,diam2));
        return myHeight;

    }

//    APPROCH 2 :
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo (int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }

    }

    public static TreeInfo diameter2(Node root,int myHeight){
        if (root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameter2(root.left, myHeight);
        TreeInfo right = diameter2(root.right, myHeight);
        int diam1 = left.diam;
        int diam2 = left.diam;
        int diam3 = left.ht + right.ht + 1;
        int myDiam = Math.max(Math.max(diam1,diam2),diam3);

        TreeInfo info = new TreeInfo(myHeight , myDiam);
        return info;
    }

    public static void main(String[] args) {
        int[] node = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binnaryTree tree = new binnaryTree();
        Node root = binnaryTree.buidTree(node);
        System.out.println(root.data);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        System.out.println(countofNode(root));
        System.out.println();
        System.out.println(sumofNode(root));
        System.out.println();
        int ht = height(root);
        System.out.println();
        System.out.println(ht);
        System.out.println();
        System.out.println(diameter(root));
        System.out.println();
        System.out.print(diameter2(root,ht));

    }

}
