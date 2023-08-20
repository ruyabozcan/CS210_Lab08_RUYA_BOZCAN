// RUYA BOZCAN
// 200201044
// COMPUTER ENGINEERING
// CS210
// LAB 08


import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TraversalAlgorithms
{
    public void PrintNode(Node node)
    {
        System.out.print(node.data + " ");
    }

    public void PostorderTraversal(Node node)
    {
        if(node == null)
            return;

        // Traverse left subtree in postorder
        PostorderTraversal(node.left);

        // Traverse right subtree in postorder
        PostorderTraversal(node.right);

        // Process root
        PrintNode(node);
    }

    public void PreorderTraversal(Node node)
    {
        if(node == null)
            return;

        // Process root
        PrintNode(node);

        // Traverse left subtree in preorder
        PreorderTraversal(node.left);

        // Traverse right subtree in preorder
        PreorderTraversal(node.right);
    }

    public void BreadthFirstTraversal(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            Node node = queue.poll();

            // Process node
            PrintNode(node);

            // Enqueue left child
            if(node.left != null)
                queue.add(node.left);

            // Enqueue right child
            if(node.right != null)
                queue.add(node.right);
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        TraversalAlgorithms ta = new TraversalAlgorithms();

        System.out.print("Postorder Traversal: ");
        ta.PostorderTraversal(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        ta.PreorderTraversal(root);
        System.out.println();

        System.out.print("Breadth-First Traversal: ");
        ta.BreadthFirstTraversal(root);
        System.out.println();
    }
}
