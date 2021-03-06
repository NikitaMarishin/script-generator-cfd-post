package commands;

import printer.Printer;

public class SetDirectoryForSaveCommand implements Command{
    private Printer printer;
    private String directoryForSave;

    public SetDirectoryForSaveCommand(String directoryForSave) {
        printer = Printer.getInstance();
        this.directoryForSave = directoryForSave;
    }

    @Override
    public String execute() {
        printer.setDirectoryForSave(directoryForSave);
        return "";
    }

    @Override
    public void undo() {

    }

    @Override
    public String toString() {
        return "SetDirectory("
                 + directoryForSave + '\'' +
                ')';
    }
}
