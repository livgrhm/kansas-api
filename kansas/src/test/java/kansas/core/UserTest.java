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

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.livgrhm.kansas.core.User;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author oliviagraham
 */
public class UserTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        // Simulate Date format for userAuthTimestamp
        java.util.Date userAuthTimestamp = new SimpleDateFormat("yyyy-MM-dd").parse("2017-01-10");
        
        // Simulate Timestamps
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date date = dateFormat.parse("2017-01-08 09:43:05");
        long time = date.getTime();
        Timestamp datetimeCreated = new Timestamp(time);
        
        // Create User
        final User user = new User(
            9,                      // userId                                                 
            "Olivia",               // firstName
            "Graham",               // lastName
            "livvy@mac.com",        // email
            "A",                    // userStatus
            "1dbe6b1ff976e267b9afee17043ea45692ddb081891b9352d1132b85ce55ea76",        // userPasswordHash
            "e0307576bc9b7ff06d2e0fb50c0b94881aee3ab54b143a94fa6f788846eb4f31",        // userAuthHash
            "0:0:0:0:0:0:0:1",      // userLastIP
            userAuthTimestamp,      // userAuthTimestamp
            0,                      // userFailedLogons
            1,                      // isActive
            0,                      // isDeleted
            null,        // datetimeCreated
            null         // datetimeUpdated
        );

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/user.json"), User.class));

        assertThat(MAPPER.writeValueAsString(user)).isEqualTo(expected);
    }
    
    @Test
    public void deserializesFromJSON() throws Exception {
        // Simulate Date format for userAuthTimestamp
        java.util.Date userAuthTimestamp = new SimpleDateFormat("yyyy-MM-dd").parse("2017-01-10");
        
        // Simulate Timestamps
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date date = dateFormat.parse("2017-01-08 09:43:05");
        long time = date.getTime();
        Timestamp datetimeCreated = new Timestamp(time);
        
        // Create User
        final User userDe = new User(
            9,                      // userId                                                 
            "Olivia",               // firstName
            "Graham",               // lastName
            "livvy@mac.com",        // email
            "A",                    // userStatus
            "1dbe6b1ff976e267b9afee17043ea45692ddb081891b9352d1132b85ce55ea76",        // userPasswordHash
            "e0307576bc9b7ff06d2e0fb50c0b94881aee3ab54b143a94fa6f788846eb4f31",        // userAuthHash
            "0:0:0:0:0:0:0:1",      // userLastIP
            userAuthTimestamp,      // userAuthTimestamp
            0,                      // userFailedLogons
            1,                      // isActive
            0,                      // isDeleted
            null,        // datetimeCreated
            null         // datetimeUpdated
        );
        
        assertThat(MAPPER.readValue(fixture("fixtures/user.json"), User.class)).isEqualToComparingFieldByField(userDe);
    }
}