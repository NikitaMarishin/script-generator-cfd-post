package gui.add_dialogs.add_panels;

import data.DataStorage;
import elements.surfaces.IsoSurface;
import elements.surfaces.Surface;
import elements.variables.Variable;

import javax.swing.*;
import java.util.Scanner;
import java.util.Vector;

public class IsoSurfaceAddPanel extends AbstractAddPanel {
    private JTextField textField;
    private JList<Variable> jList;
    private DataStorage dataStorage;

    public IsoSurfaceAddPanel(DataStorage dataStorage) {
        this.dataStorage = dataStorage;

        jList = new JList<>(dataStorage.getVariables());
        jList.setFixedCellHeight(15);
        jList.setFixedCellWidth(300);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setVisibleRowCount(20);
        add(new JScrollPane(jList));

        textField = new JTextField(30);
        add(textField);
    }

    @Override
    public Vector<Surface> getNewInstances() {
        Scanner scanner = new Scanner(textField.getText());
        Vector<Surface> result = new Vector<>();
        while (scanner.hasNextDouble()) {
            result.add(new IsoSurface(jList.getSelectedValue(), scanner.nextDouble()));
        }
        System.out.println(result);
        return result;
    }
}
