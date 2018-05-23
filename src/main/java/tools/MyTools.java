package tools;

import org.apache.log4j.Logger;

public class MyTools {
	
	public static Boolean tryToDoSomethingByConditionAndRetryCount(HandleBridge event, HandleBridge condition, int count, String content) throws Exception {
		Logger logger = Logger.getRootLogger();
		while (!condition.handleSomething()) {
			if (--count == 0) {
				logger.error(content);
				return false;
			}
			if (!event.handleSomething()) {
				break;
			}
		}
		return true;
	}

	

}
