package br.com.caelum.twittelum.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.caelum.twittelum.modelo.Tweet

@Dao
interface TweetDao {

    @Insert
    fun salvar(tweet: Tweet)

    @Query("SELECT * FROM Tweet")
    fun listar(): LiveData<List<Tweet>>

    @Delete
    fun delete(tweet: Tweet)
}