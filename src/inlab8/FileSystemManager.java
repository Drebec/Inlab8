package inlab8;

import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class FileSystemManager {

    private FileTree tree;

    public FileSystemManager() {
        tree = new FileTree();
        test();
    }

    public void run() {
        String command = " ";
        Scanner in = new Scanner(System.in);
        while (!command.equals("exit")) {
            System.out.print(tree.getLocation() + "> ");
            command = in.nextLine();
            executeCommand(command);
        }
    }

    private void executeCommand(String command) {
        int breakPoint = command.indexOf(" ");
        String argument = null;
        if (breakPoint != -1) {
            argument = command.substring(breakPoint + 1, command.length());
            command = command.substring(0, breakPoint);
        }

        if (command.equals("cd")) {
            if (!move(argument)) {
                System.out.println("File not found.\n");
            }
        } else if (command.equals("ls")) {
            System.out.println(tree.getChildren() + "\n");
        } else if (command.equals("mkdir")) {
            if (!tree.insert(argument)) {
                System.out.println("Invalid file name.\n");
            }
        } else if (command.equals("rm")) {
            if (!tree.remove(argument)) {
                System.out.println("File not found.\n");
            }
        } else if (command.equals("tree")) {
            System.out.println(tree.getSubTree());
        }else if (command.equals("exit")) {

        } else {
            System.out.println("'" + command + "' is not a recognized command");
        }
    }

    private boolean move(String file) {
        if (file == null) {
            return false;
        }

        if (file.equals("~")) {
            tree.goHome();
            return true;
        }

        if (file.equals("..")) {
            tree.moveUp();
            return true;
        }

        return tree.moveDown(file);
    }
    
    public void test() {
        tree.insert("School");
        tree.moveDown("School");
        tree.insert("CSCI111");
        tree.insert("CSCI132");
        tree.moveDown("CSCI132");        
        tree.insert("Inlabs");
        tree.moveUp();
        tree.moveUp();
        tree.insert("Skiing");
        tree.moveDown("Skiing");
        tree.insert("Pictures");
        tree.insert("Trips");
        tree.moveDown("Trips");
        tree.insert("Summer");
        tree.moveDown("Summer");
        tree.insert("Tetons");
        tree.insert("AK");
        tree.moveUp();
        tree.insert("Winter");
        tree.moveUp();
        tree.insert("Gear");
        tree.moveUp();
        tree.insert("Work");
        tree.moveDown("Work");
        tree.insert("Reviews");
        tree.insert("Paystubs");
        tree.moveDown("Paystubs");
        tree.insert("2014");
        tree.insert("2015");
        tree.moveUp();
        tree.moveUp();
        tree.insert("Personal");
        tree.moveDown("Personal");
        tree.insert("Resume");
        tree.insert("Taxes");
        tree.goHome();               
    }
}
