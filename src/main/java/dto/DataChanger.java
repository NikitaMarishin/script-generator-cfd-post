package dto;

import java.util.Vector;

public class DataChanger<T> {
    private Vector<T> vectorData;
    private DataStorage dataStorage;

    public DataChanger(Vector<T> vectorData, DataStorage dataStorage) {
        this.vectorData = vectorData;
        this.dataStorage = dataStorage;
    }

    public void addElem(int index, Vector<T> vectorToAdding) {
        vectorData.addAll(vectorToAdding);
        dataStorage.updateLists();
    }

}
