package gui.addition_dialogs.addition_panels.commands;

import elements.commands.Command;
import elements.commands.PrintElementCommand;
import data.DataStorage;
import elements.printer.Printable;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class PrintCommandAdditionPanel extends AdditionPanel {
    private JList<Printable> printElementCommandJList;

    public PrintCommandAdditionPanel(DataStorage dataStorage) {
        printElementCommandJList = new JList<>(dataStorage.getPrintableElements());
        printElementCommandJList.setFixedCellHeight(15);
        printElementCommandJList.setFixedCellWidth(300);
        printElementCommandJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        printElementCommandJList.setVisibleRowCount(20);

        add(new JScrollPane(printElementCommandJList));
    }

    @Override
    public Vector<Command> getNewInstances() {
        List<Command> commandList = printElementCommandJList.getSelectedValuesList().stream()
                .map(x -> new PrintElementCommand(x))
                .collect(Collectors.toList());
        return new Vector<>(commandList);
    }
}
