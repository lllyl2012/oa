package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog {
	private Log log = LogFactory.getLog(this.getClass());
	@Test
	public void testLog() {
		log.debug("11");
		log.error("22");
		log.info("33");
	}
}
