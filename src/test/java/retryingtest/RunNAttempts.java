package retryingtest;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunNAttempts implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new RunNStatement(base, description);
    }

    public class RunNStatement extends Statement {
        private final Statement base;
        private Description description;

        public RunNStatement(Statement base, Description description) {
            this.base = base;
            this.description = description;
        }

        @Override
        public void evaluate() throws Throwable {

            for (int i = 1; i < description.getAnnotation(Unstable.class).attempts(); i++) {
                try {
                    base.evaluate();
                } catch (Throwable t) {
                    System.out.println("Failed on " + i + " attempt : " + description);
                }
            }
        }
    }
}
