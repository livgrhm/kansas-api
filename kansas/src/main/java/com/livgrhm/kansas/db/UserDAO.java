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
package com.livgrhm.kansas.db;

import com.livgrhm.kansas.core.User;
import com.livgrhm.kansas.core.UserMapper;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface UserDAO {
//    @SqlUpdate("create table something (id int primary key, name varchar(100))")
//    void createSomethingTable();
//
    @SqlUpdate("update user set userAuthHash=:authHash, userAuthTimestamp=:now, "
            + "userLastIP=:lastIP where userId=:userId")
    void setUserAuthHash(@Bind("userId") int userId, @Bind("authHash") String authHash, 
            @Bind("now") java.sql.Date now, @Bind("lastIP") String lastIP);
    
    @SqlQuery("select * from user where userId=:id")
    @Mapper(UserMapper.class)
    User getUserById(@Bind("id") int id);
    
    @SqlQuery("select * from user where email=:email")
    @Mapper(UserMapper.class)
    User getUserByEmail(@Bind("email") String email);
    
    @SqlQuery("select * from user")
    @Mapper(UserMapper.class)
    List<User> getUsers();
}