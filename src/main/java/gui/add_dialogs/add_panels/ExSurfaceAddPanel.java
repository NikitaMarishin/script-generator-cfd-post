package gui.add_dialogs.add_panels;

import elements.surfaces.ExistingSurface;
import elements.surfaces.Surface;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import java.util.Vector;
import java.util.stream.Collectors;

public class ExSurfaceAddPanel extends AbstractAddPanel {
    private JTextField textField;

    public ExSurfaceAddPanel() {
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
