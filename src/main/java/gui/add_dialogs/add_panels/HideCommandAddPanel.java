package gui.add_dialogs.add_panels;

import commands.Command;
import commands.HideCommand;
import commands.Hideable;
import dto.DataStorage;
import surfaces.Surface;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class HideCommandAddPanel extends AbstractAddPanel {
    private JList<Surface> hideableJList;

    public HideCommandAddPanel(DataStorage dataStorage) {

        hideableJList = new JList<>(dataStorage.getSurfaces());
        hideableJList.setFixedCellHeight(15);
        hideableJList.setFixedCellWidth(300);
        hideableJList.setVisibleRowCount(20);
        add(new JScrollPane(hideableJList));
    }

    @Override
    public Vector<Command> getNewInstances() {
        List<Command> hideableList =hideableJList.getSelectedValuesList().stream()
                .map(x -> new HideCommand(x))
                .collect(Collectors.toList());
        return new Vector<>(hideableList);
    }
}
