import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTests {

    static private Path path;

    String nameOfFolder;

    @Parameterized.Parameters(name = "nameOfFolder : {0}")
    public static Collection<Object> parameters() {
        return Arrays.asList(new Object[] {"123", "dfafdsa" , "HelloWorld123.txt"});
    }

    public ParameterizedTests(String name) {
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
