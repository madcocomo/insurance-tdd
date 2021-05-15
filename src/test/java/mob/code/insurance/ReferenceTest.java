package mob.code.insurance;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class ReferenceTest {
    @Test
    public void ClockAndLocalDateExample() {
            LocalDate startDate = LocalDate.now(Clock.systemUTC());
            LocalDate date1 = LocalDate.parse("2020-11-15");
            LocalDate date2 = LocalDate.parse("2020-01-15");
            assertEquals(0L, ChronoUnit.YEARS.between(date1, startDate));
            assertEquals(1L, ChronoUnit.YEARS.between(date2, startDate));
    }
}
