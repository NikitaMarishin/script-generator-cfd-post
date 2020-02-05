package gui.managed_panels;


import dto.DataStorage;
import gui.add_dialogs.AbstractAddDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public abstract class ManagedElementsPanelAbstract<T> extends JPanel {

    private DataStorage dataStorage;
    private Vector<T> vectorOfManagedElements;
    private JList<T> jListOfElements;
    private JPanel panelWithButtons;
    private AbstractAddDialog addDialog;


    protected void init(DataStorage dataStorage, AbstractAddDialog addDialog, Vector<T> vectorOfManagedElements) {
        this.dataStorage = dataStorage;
        this.addDialog = addDialog;
        this.vectorOfManagedElements = vectorOfManagedElements;

        jListOfElementsInit();
        panelWithButtonsInit();

        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));

        add(new JScrollPane(jListOfElements));
        add(panelWithButtons);
    }

    private void jListOfElementsInit() {
        jListOfElements = new JList<>(vectorOfManagedElements);
        jListOfElements.setFixedCellHeight(15);
        jListOfElements.setFixedCellWidth(300);
        jListOfElements.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jListOfElements.setVisibleRowCount(25);
        dataStorage.addListForUpdate(jListOfElements);

    }

    private void panelWithButtonsInit() {
        panelWithButtons = new JPanel();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog.setVisible(true);
            }
        });



        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jListOfElements.getSelectedValuesList().stream()
                        .forEach(s-> vectorOfManagedElements.remove(s));
                jListOfElements.setListData(vectorOfManagedElements);
            }
        });

        panelWithButtons.add(addButton);
        panelWithButtons.add(deleteButton);

        panelWithButtons.setLayout(new GridLayout(2,1,10,100));
    }

}
