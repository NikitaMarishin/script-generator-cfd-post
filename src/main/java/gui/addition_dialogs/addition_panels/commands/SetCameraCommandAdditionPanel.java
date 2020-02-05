package gui.addition_dialogs.addition_panels.commands;

import elements.cameras.Camera;
import elements.commands.Command;
import elements.commands.SetCameraCommand;
import data.DataStorage;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.Vector;

public class SetCameraCommandAdditionPanel extends AdditionPanel {
    private JList<Camera> cameraJList;

    public SetCameraCommandAdditionPanel(DataStorage dataStorage) {
        cameraJList = new JList<>(dataStorage.getCameras());
        cameraJList.setFixedCellHeight(15);
        cameraJList.setFixedCellWidth(300);
        cameraJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cameraJList.setVisibleRowCount(20);
        add(new JScrollPane(cameraJList));
    }

    @Override
    public Vector<Command> getNewInstances() {
        Vector<Command> result = new Vector<>();
        result.add(new SetCameraCommand(cameraJList.getSelectedValue()));
        return result;
    }
}
