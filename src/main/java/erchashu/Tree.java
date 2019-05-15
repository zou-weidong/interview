package erchashu;

public class Tree {
    private Node root;

    /**
     * 从根节点
     *
     * @param value
     */
    public void insert(long value) {
        Node n = new Node(value);
        //引用当前节点
        Node cur = root;
        //引用当前节点
        Node par;
        if (root == null) {
            root = n;
            return;
        } else {
            while (true) {
                //父节点指向当前节点
                par = cur;
                if (cur.getData() > value) {
                    cur = cur.getLeft();

                } else {
                    cur = cur.getRight();
                }

            }

        }
    }

    public void find(long value) {

    }


}
