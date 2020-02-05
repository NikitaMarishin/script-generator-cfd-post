package gui.addition_dialogs.addition_panels;

import javax.swing.*;
import java.util.Vector;

public abstract class AdditionPanel<T> extends JPanel {

    public abstract Vector<T> getNewInstances();

}