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
package kansas.resources;

import com.livgrhm.kansas.api.AuthMap;
import com.livgrhm.kansas.core.User;
import com.livgrhm.kansas.db.UserDAO;
import com.livgrhm.kansas.resources.UserResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author oliviagraham
 */
public class UserResourceTest {

    private static final UserDAO dao = mock(UserDAO.class);
    private static final AuthMap checkAuth = new AuthMap(dao);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new UserResource(dao, checkAuth))
            .build();
    
    private User user;

    @Before
    public void setup() {
        // Simulate Date format for userAuthTimestamp
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date userAuthTimestamp = null;
        try {
            userAuthTimestamp = dateFormat.parse("2017-01-10");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Simulate Timestamps
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp timestamp = null;
        try {
            java.util.Date date = dateTimeFormat.parse("2017-01-08 09:43:05");
            long time = date.getTime();
            timestamp = new Timestamp(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        user = new User(
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
            timestamp,              // datetimeCreated
            timestamp               // datetimeUpdated
        );
    }

    @After
    public void tearDown() {
        // we have to reset the mock after each test because of the
        // @ClassRule, or use a @Rule as mentioned below.
        reset(dao);
    }

    @Test
    public void testGetPerson() {
//        assertThat(resources.client().target("/user/1").request().get(User.class))
//                .isEqualTo(user);
//        verify(dao).getUserById(1);
    }
}