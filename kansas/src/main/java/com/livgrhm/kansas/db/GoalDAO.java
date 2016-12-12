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

import com.livgrhm.kansas.core.Goal;
import com.livgrhm.kansas.core.GoalMapper;
import com.livgrhm.kansas.core.User;
import com.livgrhm.kansas.core.UserMapper;
import java.util.Date;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 *
 * @author oliviagraham
 */
public interface GoalDAO {
    
    /**
     * Get List of All Goals
     * @return  List of Goal objects
     */
    @SqlQuery("select * from goal")
    @Mapper(GoalMapper.class)
    List<Goal> getGoals();
    
    /**
     * Get List of All Goals by User ID
     * @param id    user ID
     * @return      List of Goal objects
     */
    @SqlQuery("select * from goal where userId=:id")
    @Mapper(GoalMapper.class)
    List<Goal> getGoalsByUserId(@Bind("id") int id);
    
    /**
     * Get Goal by Goal ID
     * @param id    goal ID
     * @return      Goal object
     */
    @SqlQuery("select * from goal where goalId=:id")
    @Mapper(GoalMapper.class)
    Goal getGoalById(@Bind("id") int id);
}
