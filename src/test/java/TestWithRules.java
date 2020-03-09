import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import java.nio.file.Path;

public class TestWithRules implements MyCategories {
    static private Path path;


    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    @Category(PositiveTests.class)
    public void createFileWithNumbersTest() throws IOException {
        File file = new File(temporaryFolder.getRoot() + "123");
        Assert.assertTrue(file.createNewFile());
    }

    @Test
    @Category(PositiveTests.class)
    public void createFileWithLettersTest() throws IOException {
        File file = new File(temporaryFolder.getRoot() + "HelloWorld");
        Assert.assertTrue(file.createNewFile());
    }

    @Test
    @Category(PositiveTests.class)
    public void createFileWithExpansion() throws IOException {
        File file = new File(temporaryFolder.getRoot() + "123HelloWorld.txt");
        Assert.assertTrue(file.createNewFile());
    }

    @Test
    @Category(NegativeTests.class)
    public void createFileWithBadName() throws IOException {
        File file = new File(temporaryFolder.getRoot() + "");
        Assert.assertFalse(file.createNewFile());
    }
}
