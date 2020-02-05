package elements.commands;

import elements.printer.Printer;

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
    public String toString() {
        return "SetDirectory("
                 + directoryForSave + '\'' +
                ')';
    }
}
