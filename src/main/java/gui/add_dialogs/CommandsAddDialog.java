package gui.add_dialogs;

import data.DataStorage;
import gui.add_dialogs.add_panels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CommandsAddDialog extends AbstractAddDialog{
    public CommandsAddDialog(DataStorage dataStorage) {

        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Set Directory", true));
        radioButtons.add(new JRadioButton("Show"));
        radioButtons.add(new JRadioButton("Hide"));
        radioButtons.add(new JRadioButton("Set Camera"));
        radioButtons.add(new JRadioButton("Print"));

        Map<String, AbstractAddPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Set Directory", new SetDirectoryCommandAddPanel());
        panelForCreation.put("Show", new ShowCommandAddPanel(dataStorage));
        panelForCreation.put("Hide", new HideCommandAddPanel(dataStorage));
        panelForCreation.put("Set Camera", new SetCameraCommandAddPanel(dataStorage));
        panelForCreation.put("Print", new PrintCommandAddPanel(dataStorage));


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
