package gui.add_dialogs;

import data.DataStorage;
import gui.add_dialogs.add_panels.AbstractAddPanel;
import gui.add_dialogs.add_panels.ExSurfaceAddPanel;
import gui.add_dialogs.add_panels.IsoSurfaceAddPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SurfaceAddDialog extends AbstractAddDialog {
    public SurfaceAddDialog(DataStorage dataStorage) {
        this.dataStorage = dataStorage;


        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Ex Surface", true));
        radioButtons.add(new JRadioButton("IsoSurface"));


        Map<String, AbstractAddPanel> panelForCreation = new HashMap<>();
        panelForCreation.put(radioButtons.get(0).getText(), new ExSurfaceAddPanel());
        panelForCreation.put(radioButtons.get(1).getText(), new IsoSurfaceAddPanel(dataStorage));


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
