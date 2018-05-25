package testcase;

import org.apache.log4j.Logger;
import org.junit.Test;

import base.BaseTest;

public class test1 extends BaseTest {
	Logger logger = Logger.getRootLogger();
	
	public String caseName() {
		return "case1";
	}
	
	@Test
	public void test() throws Exception {
		HomePage().tapTakePhoto();
		logger.debug("通过");
	}

}
