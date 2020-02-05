package gui.addition_dialogs.addition_panels.cameras;

import elements.cameras.Camera;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.Vector;

public class CameraAdditionPanel extends AdditionPanel {

    private JTextField cameraName;
    private JTextArea cameraDescription;

    public CameraAdditionPanel() {
        cameraName =new JTextField(30);
        add(cameraName);

        cameraDescription = new JTextArea();
        cameraDescription.setColumns(30);
        cameraDescription.setRows(20);

        add(new JScrollPane(cameraDescription));
    }

    @Override
    public Vector<Camera> getNewInstances() {
        Vector<Camera> result = new Vector<>();
        result.add(new Camera(cameraName.getText(), cameraDescription.getText()));
        System.out.println(result);
        return result;
    }

}
