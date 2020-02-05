package gui.add_dialogs.add_panels;

import commands.Command;
import commands.HideCommand;
import commands.PrintElementCommand;
import dto.DataStorage;
import printer.Printable;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class PrintCommandAddPanel extends AbstractAddPanel {
    private JList<Printable> printElementCommandJList;

    public PrintCommandAddPanel(DataStorage dataStorage) {
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
