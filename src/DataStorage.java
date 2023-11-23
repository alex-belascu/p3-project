import java.util.List;

public interface DataStorage<T> {
    void saveData(List<T> data);
    List<T> loadData();
}
