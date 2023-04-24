package mainWindow;

import java.awt.*;

public class CommandLineInterface extends Frame {
    private TextArea cmdTextArea;
    private TextField inputTextField;

    public CommandLineInterface() {
        super("Command Line Interface");
        setLayout(new BorderLayout());

        // create cmd text area and set the foreground and background color
        cmdTextArea = new TextArea();
        cmdTextArea.setForeground(Color.GREEN);
        cmdTextArea.setBackground(Color.BLACK);
        cmdTextArea.setEditable(false);
        add(cmdTextArea, BorderLayout.CENTER);

        // create input text field and set the foreground and background color
        inputTextField = new TextField();
        inputTextField.setForeground(Color.GREEN);
        inputTextField.setBackground(Color.BLACK);
        inputTextField.addActionListener(e -> {
            String command = inputTextField.getText();
            processCommand(command);
            inputTextField.setText("");
        });
        add(inputTextField, BorderLayout.SOUTH);

        // set the size of the frame
        setSize(600, 400);
        setVisible(true);
    }

    private void processCommand(String command) {
        switch (command) {
            case "hello":
                cmdTextArea.append("Hello, world!\n");
                break;
            case "exit":
                cmdTextArea.append("Exiting program...\n");
                dispose();
                break;
            default:
                cmdTextArea.append("Unknown command: " + command + "\n");
                break;
        }
    }

    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
    }
}






