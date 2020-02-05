package gui.add_dialogs;

import data.DataStorage;
import gui.add_dialogs.add_panels.AbstractAddPanel;
import gui.add_dialogs.add_panels.VariableAddPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class VariableAddDialog extends AbstractAddDialog {

    public VariableAddDialog(DataStorage dataStorage) {
        this.dataStorage = dataStorage;

        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Regular Variables", true));

        Map<String, AbstractAddPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Regular Variables", new VariableAddPanel());


        addDialogInit(dataStorage, radioButtons, panelForCreation);
    }

    @Override
    ActionListener setApplyButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataStorage.addVariables(0, currentPanel.getNewInstances());
            }
        };
    }
}
