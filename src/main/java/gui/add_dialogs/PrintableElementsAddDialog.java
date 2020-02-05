package gui.add_dialogs;

import dto.DataStorage;
import gui.add_dialogs.add_panels.AbstractAddPanel;
import gui.add_dialogs.add_panels.ContourAddPanel;
import gui.add_dialogs.add_panels.ExContourAddPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PrintableElementsAddDialog extends AbstractAddDialog{
    public PrintableElementsAddDialog(DataStorage dataStorage) {
        this.dataStorage = dataStorage;

        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Contour", true));
        radioButtons.add(new JRadioButton("Ex Contour"));

        Map<String, AbstractAddPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Contour", new ContourAddPanel(dataStorage));
        panelForCreation.put("Ex Contour", new ExContourAddPanel());


        addDialogInit(dataStorage, radioButtons, panelForCreation);
    }

    @Override
    ActionListener setApplyButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataStorage.addPrintable(0, currentPanel.getNewInstances());
            }
        };
    }
}
