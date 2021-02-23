package io.swagger.petstore.api.app;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  public static final ApplicationManager app = new ApplicationManager();

  @BeforeSuite(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @BeforeMethod
  public void logTestStart(Method m) {
    logger.info("Start test " + m.getName());
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }
}
