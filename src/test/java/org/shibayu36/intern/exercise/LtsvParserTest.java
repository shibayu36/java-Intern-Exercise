package org.shibayu36.intern.exercise;

import org.junit.Test;
import org.shibayu36.intern.exercise.exception.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/18.
 */
public class LtsvParserTest {
    @Test
    public void testParseSuccess() throws Exception {
        List<LtsvLog> logs = LtsvParser.parse("sample_data/log.ltsv");

        assertEquals(5, logs.size());

        assertEquals("127.0.0.1", logs.get(0).host);
        assertEquals("frank", logs.get(0).user);
        assertEquals(1372694390, logs.get(0).epoch);
        assertEquals("GET /apache_pb.gif HTTP/1.0", logs.get(0).req);
        assertEquals(200, logs.get(0).status);
        assertEquals(2326, logs.get(0).size);
        assertEquals("http://www.hatena.ne.jp/", logs.get(0).referer);
    }

    @Test
    public void testParseLtsvIOException() throws Exception {
        try {
            List<LtsvLog> logs = LtsvParser.parse("sample_data/log_nothing.ltsv");
        }
        catch (LtsvException e) {
            assertTrue(e instanceof LtsvIOException);
        }
    }

    @Test
    public void testParseLtsvParseException() throws Exception {
        try {
            List<LtsvLog> logs = LtsvParser.parse("sample_data/wrong_log.ltsv");
        }
        catch (LtsvException e) {
            assertTrue(e instanceof LtsvParseException);
        }
    }
}
