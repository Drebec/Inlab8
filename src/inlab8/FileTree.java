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
        Node currentReset = current;
        String locationReset = location;        
        while (file.indexOf("\\", 0) != -1) {
            boolean exists = false;
            int endIndex = file.indexOf("\\", 0);
            String subFile = file.substring(0, endIndex);
            for (Node c : current.getChildren()) {
                if (subFile.equals(c.getName())) {
                    current = c;
                    location += "\\" + current.getName();
                    exists = true;
                    file = file.substring(endIndex + 1);
                }
            }
            if (!exists) {
                current = currentReset;
                location = locationReset;
                return false;
            }
        }
        for (Node c : current.getChildren()) {
            if (file.equals(c.getName())) {
                current = c;
                location += "\\" + current.getName();
                return true;
            }
        }
        current = currentReset;
        location = locationReset;
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

    public String getSubTree() {
        return getSubTree(current, 0);
    }

    public String getSubTree(Node node, int depth) {
        String output = "";
        output += repeat("    ", depth) + node.getName() + "\n";

        for (Node c : node.getChildren()) {
            output += getSubTree(c, depth + 1);
        }

        return output;
    }

    public String repeat(String s, int times) {
        if (times == 0) {
            return "";
        } else {
            return s + repeat(s, times - 1);
        }
    }
}
