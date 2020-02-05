package elements.commands;

import elements.Printable;
import elements.printer.Printer;

public class PrintElementCommand implements Command{
    private Printer printer;
    private Printable elementToPrint;

    public PrintElementCommand(Printable elementToPrint) {
        printer = Printer.getInstance();
        this.elementToPrint = elementToPrint;
    }

    @Override
    public String execute() {
        printer.setElementToPrint(elementToPrint);
        return printer.getScript();
    }

    @Override
    public String toString() {
        return "Print("
                + elementToPrint +
                ')';
    }
}
