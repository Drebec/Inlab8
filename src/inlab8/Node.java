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
}
