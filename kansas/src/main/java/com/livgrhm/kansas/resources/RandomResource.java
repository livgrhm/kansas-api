/*
 * The MIT License
 *
 * Copyright 2016 oliviagraham.
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
package com.livgrhm.kansas.resources;

import com.codahale.metrics.annotation.Timed;
import com.livgrhm.kansas.api.SystemType;
import com.livgrhm.kansas.core.Test;
import com.livgrhm.kansas.db.MyDAO;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import org.skife.jdbi.v2.DBI;

@Path("/random")
@Produces(MediaType.APPLICATION_JSON)
public class RandomResource {
    private final String systemType;
    private final Date lastRefresh;
    
    private final MyDAO dao;

    public RandomResource(MyDAO dao, String systemType) {
        this.dao = dao;
        this.systemType = systemType;
        this.lastRefresh = new Date();   
    }

    @GET
    @Timed
    public SystemType whatSystem(@QueryParam("name") Optional<String> name) {
        final String value = this.systemType;
        
        System.out.println("RANDOM RESOURCE");
        System.out.println("SystemType=" + this.systemType);
        Iterator<Test> testNames = this.dao.findAllNames();
        while (testNames.hasNext()) {
            Test item = testNames.next();
            System.out.println("testID: " + item.getTestId());
            System.out.println("testContent: " + item.getTestContent());
        }
        
        return new SystemType(value);
    }
}