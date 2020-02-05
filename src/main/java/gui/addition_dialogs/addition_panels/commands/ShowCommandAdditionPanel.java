package gui.addition_dialogs.addition_panels.commands;

import elements.commands.Command;
import elements.commands.ShowCommand;
import data.DataStorage;
import elements.surfaces.Surface;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ShowCommandAdditionPanel extends AdditionPanel {
    private JList<Surface> showableJList;

    public ShowCommandAdditionPanel(DataStorage dataStorage) {

        showableJList = new JList<>(dataStorage.getSurfaces());
        showableJList.setFixedCellHeight(15);
        showableJList.setFixedCellWidth(300);
        showableJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        showableJList.setVisibleRowCount(20);
        add(new JScrollPane(showableJList));
    }

    @Override
    public Vector<Command> getNewInstances() {
        List<Command> listCommand = showableJList.getSelectedValuesList().stream()
                .map(x-> new ShowCommand(x))
                .collect(Collectors.toList());
        Vector<Command> result = new Vector<>();
        result.addAll(listCommand);
        return result;
    }
}
