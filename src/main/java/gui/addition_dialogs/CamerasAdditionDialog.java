package gui.addition_dialogs;

import data.DataStorage;
import gui.addition_dialogs.addition_panels.AdditionPanel;
import gui.addition_dialogs.addition_panels.cameras.CameraAdditionPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CamerasAdditionDialog extends AdditionDialog {


    public CamerasAdditionDialog(DataStorage dataStorage) {


        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Camera", true));

        Map<String, AdditionPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Camera", new CameraAdditionPanel());

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
