import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        TestWithCategory.class
})

@RunWith(Categories.class)
@Categories.IncludeCategory({MyCategories.PositiveTests.class, MyCategories.NegativeTests.class})

public class OrderSuite {
}
