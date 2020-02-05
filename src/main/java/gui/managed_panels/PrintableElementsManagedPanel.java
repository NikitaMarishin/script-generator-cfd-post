package gui.managed_panels;

import data.DataStorage;
import gui.addition_dialogs.PrintableElementsAdditionDialog;
import elements.printer.Printable;


public class PrintableElementsManagedPanel extends ManagedPanel<Printable> {
    public PrintableElementsManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new PrintableElementsAdditionDialog(dataStorage), dataStorage.getPrintableElements());
    }
}
