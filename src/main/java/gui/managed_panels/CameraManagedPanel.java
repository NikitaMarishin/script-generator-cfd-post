package gui.managed_panels;

import elements.cameras.Camera;
import dto.DataStorage;
import gui.add_dialogs.CameraAddDialog;

public class CameraManagedPanel extends ManagedElementsPanelAbstract<Camera> {

    public CameraManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new CameraAddDialog(dataStorage), dataStorage.getCameras());
    }
}
