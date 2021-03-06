package gui.add_dialogs.add_panels;

import contours.Contour;
import dto.DataStorage;
import printer.Printable;
import surfaces.Surface;
import variables.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ContourAddPanel extends AbstractAddPanel {
    private JList<Variable> variableJList;
    private JList<Surface> surfaceJList;
    private JTextField minValue;
    private JTextField maxValue;
    private JTextField divisions;

    public ContourAddPanel(DataStorage dataStorage) {
        variableJList = new JList<>(dataStorage.getVariables());
        variableJList.setFixedCellHeight(15);
        variableJList.setFixedCellWidth(150);
        variableJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        variableJList.setVisibleRowCount(20);
        add(new JScrollPane(variableJList));

        surfaceJList = new JList<>(dataStorage.getSurfaces());
        surfaceJList.setFixedCellHeight(15);
        surfaceJList.setFixedCellWidth(150);
        surfaceJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        surfaceJList.setVisibleRowCount(20);
        add(new JScrollPane(surfaceJList));

        JPanel panelContourSetting = new JPanel();
        panelContourSetting.setLayout(new GridLayout(1, 3,10,10));


        minValue = new JTextField(5);
        panelContourSetting.add(minValue);
        maxValue = new JTextField(5);
        panelContourSetting.add(maxValue);
        divisions = new JTextField(5);
        panelContourSetting.add(divisions);

        add(panelContourSetting);
    }


    @Override
    public Vector<Printable> getNewInstances() {
        List<Printable> printableList = surfaceJList.getSelectedValuesList().stream()
                .map(x-> new Contour(x, variableJList.getSelectedValue()))
                .map(x-> x.setLimits(Double.parseDouble(minValue.getText()),
                        Double.parseDouble(maxValue.getText()), Integer.parseInt(divisions.getText())))
                .collect(Collectors.toList());
        return new Vector<>(printableList);
    }
}
