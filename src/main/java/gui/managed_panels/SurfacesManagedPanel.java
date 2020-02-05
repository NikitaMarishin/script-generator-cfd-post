package gui.managed_panels;

import dto.DataStorage;
import gui.add_dialogs.SurfaceAddDialog;
import elements.surfaces.Surface;

public class SurfacesManagedPanel extends ManagedElementsPanelAbstract<Surface> {

    public SurfacesManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new SurfaceAddDialog(dataStorage), dataStorage.getSurfaces());
    }

}
