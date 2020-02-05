package gui.managed_panels;

import data.DataStorage;
import gui.addition_dialogs.SurfacesAdditionDialog;
import elements.surfaces.Surface;

public class SurfacesManagedPanel extends ManagedPanel<Surface> {

    public SurfacesManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new SurfacesAdditionDialog(dataStorage), dataStorage.getSurfaces());
    }

}
