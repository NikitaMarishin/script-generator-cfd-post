package data;

import elements.commands.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;

public class ScriptGenerator {
    private Vector<Command> commandVector;
    private String directoryForScript = "";

    public ScriptGenerator(Vector<Command> commandVector) {
        this.commandVector = commandVector;
    }

    public void generateScript() {
        String script = commandVector.stream()
                .map(Command::execute)
                .reduce("", (acc, next) -> acc + "\n" + next);
        File file = new File(directoryForScript + "Script.cse");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.printf(script);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
