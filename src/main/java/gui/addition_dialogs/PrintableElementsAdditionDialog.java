package gui.addition_dialogs;

import data.DataStorage;
import gui.addition_dialogs.addition_panels.AdditionPanel;
import gui.addition_dialogs.addition_panels.printable_elements.ContourAdditionPanel;
import gui.addition_dialogs.addition_panels.printable_elements.ExContourAdditionPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PrintableElementsAdditionDialog extends AdditionDialog {
    public PrintableElementsAdditionDialog(DataStorage dataStorage) {
        this.dataStorage = dataStorage;

        Vector<JRadioButton> radioButtons = new Vector<>();
        radioButtons.add(new JRadioButton("Contour", true));
        radioButtons.add(new JRadioButton("Ex Contour"));

        Map<String, AdditionPanel> panelForCreation = new HashMap<>();
        panelForCreation.put("Contour", new ContourAdditionPanel(dataStorage));
        panelForCreation.put("Ex Contour", new ExContourAdditionPanel());


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
