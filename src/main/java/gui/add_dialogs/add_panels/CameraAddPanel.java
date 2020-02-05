package gui.add_dialogs.add_panels;

import elements.cameras.Camera;

import javax.swing.*;
import java.util.Vector;

public class CameraAddPanel extends AbstractAddPanel {

    private JTextField cameraName;
    private JTextArea cameraDescription;

    public CameraAddPanel() {
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
