package gui.addition_dialogs.addition_panels.surfaces;

import elements.surfaces.ExistingSurface;
import elements.surfaces.Surface;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import java.util.Vector;
import java.util.stream.Collectors;

public class ExSurfaceAdditionPanel extends AdditionPanel {
    private JTextField textField;

    public ExSurfaceAdditionPanel() {
        textField = new JTextField(30);
        add(textField);
    }

    public Vector<Surface> getNewInstances() {
        String initialString = textField.getText();
        List<Surface> listResult = Arrays.stream(initialString.split("\""))
                .filter(x -> !x.contains(";"))
                .filter(x-> !x.isEmpty())
                .map(x -> new ExistingSurface(x))
                .collect(Collectors.toList());
        System.out.println("Ex Surface");
        return new Vector<>(listResult);
    }
}
