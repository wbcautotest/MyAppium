package tools;

import org.apache.log4j.Logger;

public class MyTools {
	
	/**
	 * @描述：重复做某件事，直到满足条件为止
	 * @作者：wbc
	 * @param event
	 * @param condition
	 * @param count
	 * @param content
	 * @return
	 * @throws Exception
	 */
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
