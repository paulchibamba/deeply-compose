package com.paulchibamba.deeply.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.paulchibamba.deeply.model.WeeklyReview
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface WeeklyReviewDAO {

    @Query("SELECT * FROM weekly_review WHERE weekStartDate = :weekStartDate")
    fun getWeeklyReview(weekStartDate: LocalDate): Flow<WeeklyReview>

    @Query("SELECT * FROM weekly_review WHERE weekStartDate BETWEEN :startDate AND :endDate")
    fun getWeeklyReviewsInRange(startDate: LocalDate, endDate: LocalDate): Flow<List<WeeklyReview>>

    @Query("SELECT * FROM weekly_review ORDER BY weekStartDate DESC")
    fun getAllWeeklyReviews(): Flow<List<WeeklyReview>>

    @Query("SELECT * FROM weekly_review WHERE weekStartDate < (SELECT MAX(weekStartDate) FROM weekly_review) ORDER BY weekStartDate DESC LIMIT 1")
    fun getPreviousWeeklyReview(): Flow<WeeklyReview?>

    @Insert
    suspend fun insertWeeklyReview(weeklyReview: WeeklyReview)

    @Update
    suspend fun updateWeeklyReview(weeklyReview: WeeklyReview)

    @Delete
    suspend fun deleteWeeklyReview(weeklyReview: WeeklyReview)

    @Query("DELETE FROM weekly_review")
    suspend fun deleteAllWeeklyReviews()

}