package gui.addition_dialogs;

import data.DataStorage;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

public abstract class AdditionDialog extends JDialog {

    protected DataStorage dataStorage;
    private Vector<JRadioButton> radioButtons;
    private Map<String, AdditionPanel> panelForCreation;
    private ActionListener panelSwitcherActionListener;
    private ActionListener applyButtonActionListener;
    protected AdditionPanel currentPanel;


    protected void addDialogInit(DataStorage dataStorage, Vector<JRadioButton> radioButtons, Map<String, AdditionPanel> panelForCreation) {

        this.dataStorage = dataStorage;
        this.radioButtons = radioButtons;
        this.panelForCreation = panelForCreation;

        currentPanel = panelForCreation.get(radioButtons.get(0).getText());

        setLayout(new BorderLayout());

        applyButtonActionListener = setApplyButtonActionListener();
        panelSwitcherActionListenerInit();
        radioButtonsInit();
        applyButtonInit();

        add(currentPanel, BorderLayout.CENTER);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void radioButtonsInit() {
        JPanel buttonPanel = new JPanel();

        ButtonGroup group = new ButtonGroup();

        radioButtons.forEach(x -> {
            x.setActionCommand(x.getText());
            buttonPanel.add(x);
            group.add(x);
            x.addActionListener(panelSwitcherActionListener);
        });

        add(buttonPanel, BorderLayout.NORTH);
    }

    private void applyButtonInit() {
        JButton buttonApply = new JButton("Apply");
        this.getContentPane();
        buttonApply.addActionListener(applyButtonActionListener);
        JPanel panelForButtonApply = new JPanel();
        panelForButtonApply.add(buttonApply);
        add(panelForButtonApply, BorderLayout.SOUTH);

    }


    private void panelSwitcherActionListenerInit() {
        panelSwitcherActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.setVisible(false);
                currentPanel = panelForCreation.get(e.getActionCommand());
                add(currentPanel, BorderLayout.CENTER);
                currentPanel.setVisible(true);
            }
        };
    }


    abstract ActionListener setApplyButtonActionListener();

}
