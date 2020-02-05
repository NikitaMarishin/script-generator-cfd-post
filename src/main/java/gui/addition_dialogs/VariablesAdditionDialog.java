package gui.addition_dialogs;

import data.DataStorage;
import gui.addition_dialogs.addition_panels.AdditionPanel;
import gui.addition_dialogs.addition_panels.variables.VariableAdditionPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class VariablesAdditionDialog extends AdditionDialog {

    public VariablesAdditionDialog(DataStorage dataStorage) {
        this.dataStorage = dataStorage;

        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Regular Variables", true));

        Map<String, AdditionPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Regular Variables", new VariableAdditionPanel());


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
