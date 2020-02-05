package gui.add_dialogs.add_panels;

import javax.swing.*;
import java.util.Vector;

public abstract class AbstractAddPanel<T> extends JPanel {

    public abstract Vector<T> getNewInstances();

}