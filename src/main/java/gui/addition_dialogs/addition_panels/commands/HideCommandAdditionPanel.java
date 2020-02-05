package gui.addition_dialogs.addition_panels.commands;

import elements.commands.Command;
import elements.commands.HideCommand;
import data.DataStorage;
import elements.surfaces.Surface;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class HideCommandAdditionPanel extends AdditionPanel {
    private JList<Surface> hideableJList;

    public HideCommandAdditionPanel(DataStorage dataStorage) {

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