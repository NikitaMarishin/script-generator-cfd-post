package gui.addition_dialogs;

import data.DataStorage;
import gui.addition_dialogs.addition_panels.*;
import gui.addition_dialogs.addition_panels.commands.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CommandsAdditionDialog extends AdditionDialog {
    public CommandsAdditionDialog(DataStorage dataStorage) {

        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Set Directory", true));
        radioButtons.add(new JRadioButton("Show"));
        radioButtons.add(new JRadioButton("Hide"));
        radioButtons.add(new JRadioButton("Set Camera"));
        radioButtons.add(new JRadioButton("Print"));

        Map<String, AdditionPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Set Directory", new SetDirectoryCommandAdditionPanel());
        panelForCreation.put("Show", new ShowCommandAdditionPanel(dataStorage));
        panelForCreation.put("Hide", new HideCommandAdditionPanel(dataStorage));
        panelForCreation.put("Set Camera", new SetCameraCommandAdditionPanel(dataStorage));
        panelForCreation.put("Print", new PrintCommandAdditionPanel(dataStorage));


        addDialogInit(dataStorage, radioButtons, panelForCreation);
    }

    @Override
    ActionListener setApplyButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataStorage.addCommands(0, currentPanel.getNewInstances());
            }
        };
    }
}
