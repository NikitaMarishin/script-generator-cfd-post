package elements.contours;

import elements.Printable;

public class ExistingContour implements Printable {

    private String nameOfExistingContour;

    public ExistingContour(String nameOfExistingContour) {
        this.nameOfExistingContour = nameOfExistingContour;
    }

    @Override
    public String getName() {
        return nameOfExistingContour;
    }

    @Override
    public String toString() {
        return getName();
    }
}
