/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.test;

import org.junit.jupiter.api.Test;
import algorithm.test.baekjoon.level01.App;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
