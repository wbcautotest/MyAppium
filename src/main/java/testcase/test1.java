package testcase;

import org.apache.log4j.Logger;
import org.junit.Test;
import test.BaseTest;

public class test1 extends BaseTest {
	Logger logger = Logger.getRootLogger();

	@Test
	public void test() throws Exception {
		HomePage().tapTakePhoto();
		logger.debug("通过");
	}

}
