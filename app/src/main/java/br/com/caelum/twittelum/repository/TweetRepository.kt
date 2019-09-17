package br.com.caelum.twittelum.repository

import androidx.lifecycle.LiveData
import br.com.caelum.twittelum.dao.TweetDao
import br.com.caelum.twittelum.modelo.Tweet

class TweetRepository(private val fonteDeDados: TweetDao) {

    fun lista(): LiveData<List<Tweet>> = fonteDeDados.listar()

    fun salvar(tweet: Tweet) = fonteDeDados.salvar(tweet)

    fun delete(tweet: Tweet) = fonteDeDados.delete(tweet)

}