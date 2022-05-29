package tests;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class Config {
    public static final String BASE_URL = System.getProperty("baseUrl", "https://ctco.lv/en");
    public static final Duration CUSTOM_WAIT = Duration.ofSeconds(15);
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
}
