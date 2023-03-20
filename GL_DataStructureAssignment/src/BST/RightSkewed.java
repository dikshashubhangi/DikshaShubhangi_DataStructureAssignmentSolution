package BST;

public class RightSkewed {
	Node root;
    Node prevNode = null;
    Node headNode = null;

    class Node
    {
        int data;
        Node left, right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    RightSkewed() { root = null; }

    RightSkewed(int value) { root = new Node(value); }

    void insert(int data) { root = insertNode(root, data); }

    Node insertNode(Node root, int data)
    {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertNode(root.left, data);
        else if (data > root.data)
            root.right = insertNode(root.right, data);

        return root;
    }

    void binaryTreeToRightSkewed(Node root)
    {
        if(root == null)
            return;

        binaryTreeToRightSkewed(root.right);

        Node leftNode = root.left;

        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }


        binaryTreeToRightSkewed(leftNode);
    }

    void printRightSkewed(Node root)
    {
        if(root == null)
            return;

        printRightSkewed(root.right);
        System.out.print(root.data + " ");
    }

    public static void main (String[] args)
    {
        RightSkewed tree = new RightSkewed();
        tree.insert(50);
        tree.insert(30);
        tree.insert(60);
        tree.insert(10);
        tree.insert(55);

        tree.binaryTreeToRightSkewed(tree.root);
        tree.printRightSkewed(tree.headNode);
    }

}
