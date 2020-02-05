package gui.add_dialogs.add_panels;

import elements.cameras.Camera;
import elements.commands.Command;
import elements.commands.SetCameraCommand;
import dto.DataStorage;

import javax.swing.*;
import java.util.Vector;

public class SetCameraCommandAddPanel extends AbstractAddPanel {
    private JList<Camera> cameraJList;

    public SetCameraCommandAddPanel(DataStorage dataStorage) {
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
