/*
 * The MIT License
 *
 * Copyright 2017 oliviagraham.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package kansas.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livgrhm.kansas.core.Goal;
import io.dropwizard.jackson.Jackson;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author oliviagraham
 */
public class GoalTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        
        // Simulate Timestamps
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date date = dateFormat.parse("2016-11-26 14:59:08");
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        
        // Create Goal
        final Goal goal = new Goal(1, 9, 1, "I will have moved abroad.", 1,
                0, timestamp, timestamp);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/goal.json"), Goal.class));

        assertThat(MAPPER.writeValueAsString(goal)).isEqualTo(expected);
    }
    
    @Test
    public void deserializesFromJSON() throws Exception {
        
        // Simulate Timestamps
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date date = dateFormat.parse("2016-11-26 14:59:08");
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        
        // Create Goal
        final Goal goal = new Goal(1, 9, 1, "I will have moved abroad.", 1,
                0, timestamp, timestamp);
        
        assertThat(MAPPER.readValue(fixture("fixtures/goal.json"), Goal.class)).isEqualToComparingFieldByField(goal);
    }
}
