package br.com.caelum.twittelum.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.caelum.twittelum.application.TwittelumApplication
import br.com.caelum.twittelum.database.TwittelumDatabase
import br.com.caelum.twittelum.repository.TweetRepository
import br.com.caelum.twittelum.viewmodel.TweetViewModel

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun banco() = TwittelumDatabase.getInstance(TwittelumApplication.getInstance())
    private fun tweetDao() = banco().tweetDao()
    private fun repositorio() = TweetRepository(tweetDao())


    override fun <T : ViewModel?> create(modelClass: Class<T>) = TweetViewModel(repositorio()) as T
}