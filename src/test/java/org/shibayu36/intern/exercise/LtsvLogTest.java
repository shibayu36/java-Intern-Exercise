package org.shibayu36.intern.exercise;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/17.
 */
public class LtsvLogTest {
    @Test
    public void testLog() throws Exception {
        LtsvLog log = new LtsvLog(
                "127.0.0.1",
                "frank",
                1372694390,
                "GET /apache_pb.gif HTTP/1.0",
                200,
                2326,
                "http://www.hatena.ne.jp/"
        );
        assertEquals("GET", log.method());
        assertEquals("/apache_pb.gif", log.path());
        assertEquals("HTTP/1.0", log.protocol());
        assertEquals("http://127.0.0.1/apache_pb.gif", log.uri());
        assertEquals("2013-07-01T15:59:50", log.time());

    }

}