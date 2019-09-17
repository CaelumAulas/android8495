package br.com.caelum.twittelum.viewmodel

import androidx.lifecycle.ViewModel
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.repository.TweetRepository

class TweetViewModel(private val repositorio: TweetRepository) : ViewModel() {

    fun listar() = repositorio.lista()

    fun salvar(tweet: Tweet) = repositorio.salvar(tweet)

    fun delete(tweet: Tweet) = repositorio.delete(tweet)

}