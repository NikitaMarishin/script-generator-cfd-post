package gui.addition_dialogs.addition_panels.printable_elements;

import elements.contours.ExistingContour;
import elements.Printable;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ExContourAdditionPanel extends AdditionPanel {
    private JTextField namesOfExContoursField;

    public ExContourAdditionPanel() {
        namesOfExContoursField = new JTextField(30);
        add(namesOfExContoursField);
    }

    @Override
    public Vector<Printable> getNewInstances() {
        List<Printable> printableList = Arrays.stream(namesOfExContoursField.getText().split("\""))
                .filter(x -> !x.contains(";"))
                .filter(x -> !x.isEmpty())
                .map(x -> new ExistingContour(x))
                .collect(Collectors.toList());
        return new Vector<>(printableList);
    }
}
