import java.util.*;

public class BinaryTreeC3{

   static class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
   }

   //Q.1. kth level of a tree
   public static void kthLevel(Node root, int level, int k){
    if (root == null){
        return;
    }
    
    if(level == k){
        System.out.print(root.data+" ");
    }

    kthLevel(root.left, level+1, k);
    kthLevel(root.right, level+1, k);
   }

   public static boolean getPath(Node root, int n, ArrayList<Node> path){
    if(root == null){
        return false;
    }

    path.add(root);

    if(root.data == n){
        return true;
    }

    boolean foundLeft = getPath(root.left, n, path);
    boolean foundRight = getPath(root.right, n, path);

    if(foundLeft || foundRight){
        return true;
    }

    path.remove(path.size() - 1);
    return false;
   }

   // Q.2. Lowest Common Ancestor  - Approach 1
   public static Node lca(Node root, int n1, int n2){
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    getPath(root, n1, path1);
    getPath(root, n2, path2);

    int i = 0;
    for(; i<path1.size() && i < path2.size(); i++){
        if(path1.get(i) != path2.get(i)){
            break;
        }
    }

    Node lca = path1.get(i-1);
    return lca;
   }

   // Approach 2- Lca
   public static Node lca2(Node root, int n1, int n2){
    if(root == null || root.data == n1 || root.data == n2){
        return root;
    }

    Node leftLca = lca2(root.left, n1, n2);
    Node rightRca = lca2(root.right, n1, n2);

    if(rightRca == null){
        return leftLca;
    }
    if(leftLca == null){
        return rightRca;
    }


    return root;
   }

   // Q.3. Min distance between two nodes

   public static int lcaDist(Node root, int n){
   if(root == null){
     return -1;
   }
    
    if(root.data == n){
        return 0;
    }

    int leftDist = lcaDist(root.left, n);
    int rightDist = lcaDist(root.right, n);

    if(leftDist == -1 && rightDist == -1){
        return -1;
    } else if(leftDist == -1){
        return rightDist + 1;
    } else {
        return leftDist + 1;
    }

   }


   public static int minDistance(Node root, int n1, int n2){
    if(root == null){
        return -1;
    }

    Node lca = lca2(root, n1, n2);

    int dist1 = lcaDist(lca, n1);
    int dist2 = lcaDist(lca, n2);
    return dist1+dist2;
   }

   // Q.4. Kth ancestor of a node
   public static int kthAncestor(Node root, int n, int k){
    if(root == null){
        return -1;
    }

    if(root.data == n){
        return 0;
    }

    int leftDist = kthAncestor(root.left, n, k);
    int rightDist = kthAncestor(root.right, n, k);

    if(leftDist == -1 && rightDist == -1){
        return -1;
    }

    int max = Math.max(leftDist, rightDist);
    if(max+1 == k){
        System.out.println(root.data);
    }
    return max+1;
   }

   // Q.5. Transform sum of a subtree
   public static int transform(Node root){
    if(root == null){
        return 0;
    }

    int leftChild = transform(root.left);
    int rightChild = transform(root.right);

    int data = root.data;

    int newLeft = root.left == null ? 0 : root.left.data;
    int newRight = root.right == null ? 0 : root.right.data;
    root.data = newLeft + leftChild + newRight + rightChild;
    return data;
   }

   public static void preOrder(Node root){
    if(root == null){
        return;
    }

    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);
   }

    public static void main(String args[]){
     Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.right.left = new Node(6);
     root.right.right = new Node(7);

    //  kthLevel(root, 1, 3);
    // System.out.println(minDistance(root, 4, 7));
    // int n = 5, k = 2;
    // kthAncestor(root, n, k);
    transform(root);
    preOrder(root);
    }
}