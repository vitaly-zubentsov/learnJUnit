package retryingtest;

import org.junit.Assert;
import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.TestRule;

public class UnstableTest{

    private static int attemptCounter = 1;
    @Rule
    public TestRule runNAttempts = new RunNAttempts();

    @Test
    @Unstable(attempts = 3)
    public void unstableTest() {
        if (attemptCounter == 3) {
            System.out.println("Test passed");
            attemptCounter = 1;
        } else Assert.fail("Test fail - " + attemptCounter++ + " attempt");
    }
}
