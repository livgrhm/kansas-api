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
import com.livgrhm.kansas.core.GoalStep;
import com.livgrhm.kansas.core.GoalStepMapper;
import com.livgrhm.kansas.core.Habit;
import com.livgrhm.kansas.core.HabitMapper;
import com.livgrhm.kansas.core.Milestone;
import com.livgrhm.kansas.core.MilestoneMapper;
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
    @SqlQuery("select * from goal where isActive=1 and isDeleted=0")
    @Mapper(GoalMapper.class)
    List<Goal> getGoals();
    
    /**
     * Get List of All Goals by User ID
     * @param id    user ID
     * @return      List of Goal objects
     */
    @SqlQuery("select * from goal where userId=:id and isActive=1 and isDeleted=0")
    @Mapper(GoalMapper.class)
    List<Goal> getGoalsByUserId(@Bind("id") int id);
    
    /**
     * Get List of All Goal Steps for Goal by Goal ID
     * @param goalId    Goal ID
     * @return          List of Goal Step objects
     */
    @SqlQuery("select * from goalStep where goalId=:goalId and isActive=1 and isDeleted=0")
    @Mapper(GoalStepMapper.class)
    List<GoalStep> getGoalSteps(@Bind("goalId") int goalId);
    
    
    /**
     * Get List of All Milestones for Goal by Goal ID
     * @param goalId    Goal ID
     * @return          List of Milestone objects
     */
    @SqlQuery("select * from milestone where goalId=:goalId and isActive=1 and isDeleted=0")
    @Mapper(MilestoneMapper.class)
    List<Milestone> getMilestones(@Bind("goalId") int goalId);
    
    /**
     * Get List of All Habits for Goal by Goal ID
     * @param goalId
     * @return 
     */
    @SqlQuery("select h.*, ht.habitTypeDesc from habit h, habitType ht " +
            "where h.habitType=ht.habitType and h.isActive=1 and h.isDeleted=0 " +
            "and ht.isActive=1 and ht.isDeleted=0 and h.goalId=:goalId")
    @Mapper(HabitMapper.class)
    List<Habit> getHabits(@Bind("goalId") int goalId);
    
    /**
     * Get Goal by Goal ID
     * @param id    goal ID
     * @return      Goal object
     */
    @SqlQuery("select * from goal where goalId=:id and isActive=1 and isDeleted=0")
    @Mapper(GoalMapper.class)
    Goal getGoalById(@Bind("id") int id);
    
    /**
     * Create new Goal
     * @param userId        User creating the goal
     * @param timespan      Time in years to achieve the goal
     * @param goalContent   Goal title/information
     * @return              ID of created goal
     */
    @SqlUpdate("insert into goal (userId, timespan, goalContent) "
            + "values (:userId, :timespan, :goalContent)")
    @GetGeneratedKeys
    int createGoal(@Bind("userId") int userId, @Bind("timespan") int timespan,
            @Bind("goalContent") String goalContent);
    
    /**
     * Update existing goal
     * @param goalId        ID of goal to update
     * @param timespan      Time in years to achieve the goal
     * @param goalContent   Goal title/information
     */
    @SqlUpdate("update goal set timespan=:timespan, goalContent=:goalContent, "
            + "datetimeUpdated=now() where goalId=:goalId")
    void updateGoal(@Bind("goalId") int goalId, @Bind("timespan") int timespan, 
            @Bind("goalContent") String goalContent);
    
    /**
     * Delete (de-activate) existing goal
     * @param goalId        ID of goal to delete
     */
    @SqlUpdate("update goal set isActive=0, isDeleted=1, datetimeUpdated=now() where goalId=:goalId")
    void deleteGoal(@Bind("goalId") int goalId);
}
