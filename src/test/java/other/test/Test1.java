package other.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo1 on 2015/8/5.
 */
public class Test1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test1.class);


    @Test
    public void test1(){
        String str = "modelnumber=test1";
        boolean bl = str.matches("model.*");
        String[] strings = str.split("=");


        LOGGER.info("result: {}",bl);
        LOGGER.info("strings: {},{}",strings[0],strings[1]);

    }

}
