import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestWithCategory implements MyCategories{
    static private Path path;

    @BeforeClass
    public static void  createTempDirectory() throws IOException {
        path = Files.createTempDirectory("TempDirectory");
    }

    @AfterClass()
    public static void deleteTempDirectory() throws IOException {
        Files.delete(path);
    }


    @Test
    @Category(PositiveTests.class)
    public void createFileWithNumbersTest() throws IOException {
        File file = new File(path + "123");
        Assert.assertTrue(file.createNewFile());
    }

    @Test
    @Category(PositiveTests.class)
    public void createFileWithLettersTest() throws IOException {
        File file = new File(path + "HelloWorld");
        Assert.assertTrue(file.createNewFile());
    }

    @Test
    @Category(PositiveTests.class)
    public void createFileWithExpansion() throws IOException {
        File file = new File(path + "123HelloWorld.txt");
        Assert.assertTrue(file.createNewFile());
    }

    @Test
    @Category(NegativeTests.class)
    public void createFileWithBadName() throws IOException {
        File file = new File(path + "");
        Assert.assertFalse(file.createNewFile());

    }
}
