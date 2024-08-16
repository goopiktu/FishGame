package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import org.fusesource.jansi.Ansi;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp.Capability;

public final class InteractiveMenu {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";

    private static final boolean IS_SUPPORTED_CONSOLE = !Boolean.getBoolean("imenu.noFancyMenu")
            && (Boolean.getBoolean("imenu.forceFancyMenu") || System.console() != null);

    private final String[] options;

    public InteractiveMenu(String... options) {
        this.options = Arrays.copyOf(options, options.length);
    }

    public int display() throws IOException {
        if (IS_SUPPORTED_CONSOLE) {
            return fancyMenu();
        }
        return boringMenu();
    }

    private int boringMenu() {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println((options.length + 1) + ". Exit");
        int selection;
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Which option would you like? ");
            String text = in.nextLine().trim();
            if (text.isEmpty()) {
                return -1;
            }
            try {
                selection = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + text);
                continue;
            }
            if (selection < 1) {
                return selection == -1 ? -1 : 0;
            } else if (selection > options.length) {
                return -1;
            }
            return selection - 1;
        }
    }

    private int fancyMenu() throws IOException {
        int selection = 0;
        try (Terminal term = TerminalBuilder.terminal()) {
            term.enterRawMode();
            PrintWriter writer = term.writer();

            KeyMap<String> keyMap = new KeyMap<>();
            keyMap.setAmbiguousTimeout(200);
            keyMap.bind("up", KeyMap.key(term, Capability.key_up));
            keyMap.bind("down", KeyMap.key(term, Capability.key_down));
            keyMap.bind("exit", KeyMap.esc(), KeyMap.ctrl('c'));
            keyMap.bind("enter", "\r");

            BindingReader bindingReader = new BindingReader(term.reader());

            for (int i = 0; i < options.length; i++) {
                String leftHand = i == 0 ? ANSI_GREEN + "> " + ANSI_RESET : "  ";
                writer.println(leftHand + "[" + (i + 1) + "] " + options[i]);
            }
            writer.println("  [" + (options.length + 1) + "] Exit");

            while (true) {
                int prevSelection = selection;
                String key = bindingReader.readBinding(keyMap);
                switch (key) {
                    case "up":
                        selection--;
                        if (selection == -1) {
                            selection = options.length;
                        }
                        break;
                    case "down":
                        selection++;
                        if (selection > options.length) {
                            selection = 0;
                        }
                        break;
                    case "enter":
                        return selection == options.length ? -1 : selection;
                    case "exit":
                        return -1;
                }
                printUp(writer, " ", options.length + 1 - prevSelection);
                printUp(writer, ANSI_GREEN + ">" + ANSI_RESET, options.length + 1 - selection);
            }
        }
    }

    private void printUp(PrintWriter writer, String s, int up) {
        writer.write(
                Ansi.ansi()
                        .cursorUp(up)
                        .a(s)
                        .cursorDown(up)
                        .cursorLeft(s.length())
                        .toString());
    }
}