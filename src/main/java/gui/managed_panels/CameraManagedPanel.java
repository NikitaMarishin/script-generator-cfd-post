package gui.managed_panels;

import elements.cameras.Camera;
import data.DataStorage;
import gui.addition_dialogs.CamerasAdditionDialog;

public class CameraManagedPanel extends ManagedPanel<Camera> {

    public CameraManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new CamerasAdditionDialog(dataStorage), dataStorage.getCameras());
    }
}
