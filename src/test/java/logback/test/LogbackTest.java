package logback.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Dell on 2015/7/31.
 */
public class LogbackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test1(){
        LOGGER.debug("test");
    }


}
