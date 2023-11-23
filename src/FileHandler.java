import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements DataStorage<Employee> {
    private static final String FILE_NAME = "employees.txt";

    @Override
    public void saveData(List<Employee> employees) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(new ArrayList<>(employees));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> loadData() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List) {
                employees = (List<Employee>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
