package elements.printer;

import elements.Printable;
import elements.surfaces.ExistingSurface;

public class Printer {
    private final static Printer instance = new Printer();
    private Printable elementToPrint;
    private String directoryForSave;

    private Printer(){
        elementToPrint = new ExistingSurface("default");
        directoryForSave = "";
    }

    public static Printer getInstance() {
        return instance;
    }

    public void setDirectoryForSave(String directoryForSave) {
        this.directoryForSave = directoryForSave;
    }

    public void setElementToPrint(Printable elementToPrint) {
        this.elementToPrint = elementToPrint;
    }

    private String getScriptForSave() {
        return "HARDCOPY:\n" +
                "  Antialiasing = On\n" +
                "  Hardcopy Filename = " + directoryForSave + elementToPrint.getName() + ".png\n" +
                "  Hardcopy Format = png\n" +
                "  Hardcopy Tolerance = 0.0001\n" +
                "  Image Height = 600\n" +
                "  Image Scale = 200\n" +
                "  Image Width = 600\n" +
                "  JPEG Image Quality = 80\n" +
                "  Screen Capture = Off\n" +
                "  Use Screen Size = On\n" +
                "  White Background = On\n" +
                "END\n" +
                ">print" + "\n";
    }

    public String getScript() {


        return elementToPrint.getScriptShow() +
                getScriptForSave() +
                elementToPrint.getScriptHide();

    }


}
