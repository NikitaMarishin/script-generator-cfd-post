package data;

import elements.cameras.Camera;
import elements.commands.Command;
import elements.printer.Printable;
import elements.surfaces.Surface;
import elements.variables.RegularVariable;
import elements.variables.Variable;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class DataStorage {
    private Vector<Surface> surfaces;
    private Vector<Variable> variables;
    private Vector<Printable> printableElements;
    private Vector<Camera> cameras;
    private Vector<Command> commands;

    private List<JList> listsForUpdate;

    private DataChanger<Surface> surfaceDataChanger;
    private DataChanger<Variable> variableDataChanger;
    private DataChanger<Printable> printableDataChanger;
    private DataChanger<Camera> cameraDataChanger;
    private DataChanger<Command> commandDataChanger;


    public DataStorage() {
        surfaces = new Vector<>();
        variables = new Vector<>(RegularVariable.getDefaultVariables());
        printableElements = new Vector<>();
        cameras = new Vector<>();
        commands = new Vector<>();
        listsForUpdate = new Vector<>();

        surfaceDataChanger = new DataChanger<>(surfaces, this);
        variableDataChanger = new DataChanger<>(variables, this);
        printableDataChanger = new DataChanger<>(printableElements, this);
        cameraDataChanger = new DataChanger<>(cameras, this);
        commandDataChanger = new DataChanger<>(commands, this);
    }

    public Vector<Surface> getSurfaces() {
        return surfaces;
    }

    public Vector<Variable> getVariables() {
        return variables;
    }

    public Vector<Printable> getPrintableElements() {
        return printableElements;
    }

    public Vector<Camera> getCameras() {
        return cameras;
    }

    public Vector<Command> getCommands() {
        return commands;
    }

    public void addSurfaces(int index, Vector<Surface> surfacesToAdd) {
        surfaceDataChanger.addElem(index, surfacesToAdd);
    }

    public void addVariables(int index, Vector<Variable> variablesToAdd) {
        variableDataChanger.addElem(index, variablesToAdd);
    }

    public void addPrintable(int index, Vector<Printable> printableToAdd) {
        printableDataChanger.addElem(index, printableToAdd);
    }

    public void addCameras(int index, Vector<Camera> camerasToAdd) {
        cameraDataChanger.addElem(index, camerasToAdd);
    }

    public void addCommands(int index, Vector<Command> commandsToAdd) {
        commandDataChanger.addElem(index, commandsToAdd);
    }

    public void addListForUpdate(JList listForUpdate) {
        listsForUpdate.add(listForUpdate);
    }

    public void updateLists() {
        listsForUpdate.forEach(JList::updateUI);
    }



}
