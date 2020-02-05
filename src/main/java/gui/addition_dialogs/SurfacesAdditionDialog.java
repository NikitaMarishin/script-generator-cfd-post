package gui.addition_dialogs;

import data.DataStorage;
import gui.addition_dialogs.addition_panels.AdditionPanel;
import gui.addition_dialogs.addition_panels.surfaces.ExSurfaceAdditionPanel;
import gui.addition_dialogs.addition_panels.surfaces.IsoSurfaceAdditionPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SurfacesAdditionDialog extends AdditionDialog {
    public SurfacesAdditionDialog(DataStorage dataStorage) {
        this.dataStorage = dataStorage;


        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Ex Surface", true));
        radioButtons.add(new JRadioButton("IsoSurface"));


        Map<String, AdditionPanel> panelForCreation = new HashMap<>();
        panelForCreation.put(radioButtons.get(0).getText(), new ExSurfaceAdditionPanel());
        panelForCreation.put(radioButtons.get(1).getText(), new IsoSurfaceAdditionPanel(dataStorage));


        addDialogInit(dataStorage, radioButtons, panelForCreation);

    }

    @Override
    ActionListener setApplyButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataStorage.addSurfaces(0, currentPanel.getNewInstances());
            }
        };
    }
}
