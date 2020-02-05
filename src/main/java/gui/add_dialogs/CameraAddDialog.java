package gui.add_dialogs;

import data.DataStorage;
import gui.add_dialogs.add_panels.AbstractAddPanel;
import gui.add_dialogs.add_panels.CameraAddPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CameraAddDialog extends AbstractAddDialog{


    public CameraAddDialog(DataStorage dataStorage) {


        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Camera", true));

        Map<String, AbstractAddPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Camera", new CameraAddPanel());

        addDialogInit(dataStorage, radioButtons, panelForCreation);

    }

    @Override
    ActionListener setApplyButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataStorage.addCameras(0, currentPanel.getNewInstances());
            }
        };
    }
}
