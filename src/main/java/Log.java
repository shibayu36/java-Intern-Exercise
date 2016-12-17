/**
 * Created by shibayu36 on 2016/12/17.
 */

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Log {
    public String host;
    public String user;
    public int epoch;
    public String req;
    public int status;
    public int size;
    public String referer;

    public Log(String host, String user, int epoch, String req, int status, int size, String referer) {
        this.host = host;
        this.user = user;
        this.epoch = epoch;
        this.req = req;
        this.status = status;
        this.size = size;
        this.referer = referer;
    }

    public String method() {
        return this.req.split(" ")[0];
    }

    public String path() {
        return this.req.split(" ")[1];
    }

    public String protocol() {
        return this.req.split(" ")[2];
    }

    public String uri() {
        return "http://" + this.host + this.path();
    }

    public String time() {
        LocalDateTime dt = LocalDateTime.ofInstant(Instant.ofEpochMilli((long)this.epoch * 1000), ZoneId.of("UTC"));
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return dt.format(f);
    }
}
