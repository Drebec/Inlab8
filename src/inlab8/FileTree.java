package inlab8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author yaw
 */
public class FileTree {

    private Node root;
    private Node current;
    private String location;

    public FileTree() {
        root = new Node("H:");
        location = root.getName();
        current = root;
    }

    public String getLocation() {
        return location;
    }

    public boolean moveDown(String file) {
        ArrayList<Node> children = current.getChildren();
        for (Node c : children) {
            if (file.equals(c.getName())) {
                current = c;
                location += "\\" + current.getName();
                return true;
            }
        }
        return false;
    }

    public void moveUp() {
        if (current != root) {
            current = current.getParent();
            int index = location.lastIndexOf("\\");
            location = location.substring(0, index);
        }
    }

    public void goHome() {
        current = root;
        location = current.getName();
    }

    public String getChildren() {
        String files = new String();
        ArrayList<Node> children = current.getChildren();
        if (children != null) {    
            for (Node c : children) {
                files += c.getName() + " ";
            }
        }
        return files;
    }

    public boolean insert(String file) {
        if (file != null && !file.equals(" ")) {
            Node newFile = new Node(file);
            newFile.setParent(current);
            current.addChild(newFile);
            return true;
        }
        return false;
    }

    public boolean remove(String file) {
        if (file != null) {
            ArrayList<Node> children = current.getChildren();
            for (Node c : children) {
                if (c.getName().equals(file)) {
                    children.remove(c);
                    return true;
                }
            }
        }
        return false;
    }
}
