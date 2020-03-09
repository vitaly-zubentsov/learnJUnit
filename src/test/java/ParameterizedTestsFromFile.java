import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ParameterizedTestsFromFile {

    static private Path path;

    String nameOfFolder;

    @Parameterized.Parameters(name = "nameOfFolder{0}")
    public static Collection<Object> parameters() {
        List<Object> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test_data.csv")))) {
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;

    }

    public ParameterizedTestsFromFile(String name) {
        this.nameOfFolder = name;
    }

    @BeforeClass
    public static void createTempDirectory() throws IOException {
        path = Files.createTempDirectory("TempDirectory");
    }

    @AfterClass
    public static void deleteTempDirectory() throws IOException {
        Files.delete(path);
    }


    @Test
    public void createFileWithNumbersTest() throws IOException {
        File file = new File(path + nameOfFolder);
        Assert.assertTrue(file.createNewFile());
    }
}
