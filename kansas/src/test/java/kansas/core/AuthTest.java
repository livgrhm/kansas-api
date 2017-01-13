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
import com.livgrhm.kansas.api.AuthenticationResult;
import io.dropwizard.jackson.Jackson;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author oliviagraham
 */
public class AuthTest {
    
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        
        // Create AuthResult
        final AuthenticationResult authResult = new AuthenticationResult("Y", 9,
        "f2da27d90631ef4a394b542f81d8aedf487a7c66bb57c5f12e2b1207b6e50218", "A");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/auth.json"), AuthenticationResult.class));

        assertThat(MAPPER.writeValueAsString(authResult)).isEqualTo(expected);
    }
    
    @Test
    public void deserializesFromJSON() throws Exception {

        // Create AuthResult
        final AuthenticationResult authResult = new AuthenticationResult("Y", 9,
        "f2da27d90631ef4a394b542f81d8aedf487a7c66bb57c5f12e2b1207b6e50218", "A");
        
        assertThat(MAPPER.readValue(fixture("fixtures/auth.json"), AuthenticationResult.class))
                .isEqualToComparingFieldByField(authResult);
    }
}
