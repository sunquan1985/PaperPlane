package com.marktony.zhihudaily.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.marktony.zhihudaily.data.DoubanMomentNewsPosts;

import java.util.List;

/**
 * Created by lizhaotailang on 2017/6/15.
 */

@Dao
public interface DoubanMomentNewsDao {

    @Query("SELECT * FROM douban_moment_news")
    List<DoubanMomentNewsPosts> queryAll();

    @Query("SELECT * FROM douban_moment_news WHERE id = :id")
    DoubanMomentNewsPosts queryItemById(int id);

    @Query("SELECT * FROM douban_moment_news WHERE favorite = 1")
    List<DoubanMomentNewsPosts> queryAllFavorites();

    @Query("SELECT * FROM douban_moment_news WHERE timestamp < :timestamp")
    List<DoubanMomentNewsPosts> queryAllTimeoutItems(long timestamp);

    @Insert
    void insertAll(List<DoubanMomentNewsPosts> items);

    @Update
    void update(DoubanMomentNewsPosts item);

    @Delete
    void delete(DoubanMomentNewsPosts item);

}
