package gui.managed_panels;

import dto.DataStorage;
import gui.add_dialogs.PrintableElementsAddDialog;
import printer.Printable;


public class PrintableElementsManagedPanel extends ManagedElementsPanelAbstract<Printable> {
    public PrintableElementsManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new PrintableElementsAddDialog(dataStorage), dataStorage.getPrintableElements());
    }
}
