import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/17.
 */
public class SampleTest {
    @Test
    public void num() throws Exception {
        assertEquals(Sample.num(), 10);
    }

    @Test
    public void str() throws Exception {
        assertEquals(Sample.str(), "hoge");
    }

}