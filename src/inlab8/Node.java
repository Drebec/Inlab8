package inlab8;

import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class Node {

    private String name;
    private Node parent;
    private ArrayList<Node> children;

    public Node(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public Node getParent() {
        return parent;
    }
    
    public void getSubTree(int depth) {
        for(int i = 0; i < children.size(); i++) {
            if (i < children.size() - 1) {
                if(depth == 0) {
                    System.out.print("|---" + children.get(i).getName() + "\n");
                } else {
                    String output = String.format("%" + depth + "s", "   |") + "---";
                    System.out.print("|" + output + children.get(i).getName() + "\n");
                }
                if(children.get(i).getChildren() != null) {
                    children.get(i).getSubTree(depth + 1);
                }
            } else {
                if(depth == 0) {
                    System.out.print("`---" + children.get(i).getName() + "\n");
                } else {
                    String output = String.format("%" + depth + "s", "   |") + "---";
                    System.out.print("|" + output + children.get(i).getName() + "\n");
                }
                if(children.get(i).getChildren() != null) {
                    children.get(i).getSubTree(depth + 1);
                } 
            }
        }
    }
}