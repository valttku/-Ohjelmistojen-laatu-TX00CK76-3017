import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeUtilsTest {

    @ParameterizedTest(name = "Testi {index}: {0} sekuntia muunnetaan muotoon {1}")
    @CsvSource({
            "3665, '1:01:05'",
            "0, '0:00:00'",
            "3600, '1:00:00'",
            "60, '0:01:00'",
            "1, '0:00:01'",
            "-100, 'Negatiivinen arvo ei kelpaa'",
            "86400, '24:00:00'",
            "560, '0:09:20'",
            "30000, '8:20:00'",
    })
    public void testSecToTime(int s, String expectedTime) {
        String message = s + " sekuntia muunnetaan väärin.";
        assertEquals(expectedTime, TimeUtils.secToTime(s), message);
    }
}