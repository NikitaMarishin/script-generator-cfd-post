package gui.add_dialogs.add_panels;

import contours.ExistingContour;
import printer.Printable;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ExContourAddPanel extends AbstractAddPanel {
    private JTextField namesOfExContoursField;

    public ExContourAddPanel() {
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
