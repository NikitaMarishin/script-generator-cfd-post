package gui;

import data.DataStorage;
import data.ScriptGenerator;
import gui.managed_panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {

    private DataStorage dataStorage;
    private ScriptGenerator scriptGenerator;
    private JFrame frame;
    private JTabbedPane surfacesTab;
    private JMenuBar menuBar;


    public SwingGUI() {

        dataStorage = new DataStorage();

        scriptGenerator = new ScriptGenerator(dataStorage.getCommands());

        frame = new JFrame("CFD-Post Script Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setMinimumSize(new Dimension(500, 500));


        surfacesTab = new JTabbedPane();
        surfacesTab.addTab("Surfaces", new SurfacesManagedPanel(dataStorage));
        surfacesTab.addTab("Variables", new VariablesManagedPanel(dataStorage));
        surfacesTab.addTab("Cameras", new CameraManagedPanel(dataStorage));
        surfacesTab.addTab("Printable elements", new PrintableElementsManagedPanel(dataStorage));
        surfacesTab.addTab("Script", new CommandsMangedPanel(dataStorage));

        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem generateScript = new JMenuItem("Generate Script");
        generateScript.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scriptGenerator.generateScript();
            }
        });
        fileMenu.add(generateScript);
        frame.setJMenuBar(menuBar);


        frame.setLayout(new BorderLayout());
        frame.add(surfacesTab, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }


}
