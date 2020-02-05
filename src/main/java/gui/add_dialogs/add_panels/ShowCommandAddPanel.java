package gui.add_dialogs.add_panels;

import commands.Command;
import commands.ShowCommand;
import commands.Showable;
import dto.DataStorage;
import surfaces.Surface;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ShowCommandAddPanel extends AbstractAddPanel{
    private JList<Surface> showableJList;

    public ShowCommandAddPanel(DataStorage dataStorage) {

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
