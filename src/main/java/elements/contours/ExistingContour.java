package elements.contours;


public class ExistingContour implements Contour {

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
