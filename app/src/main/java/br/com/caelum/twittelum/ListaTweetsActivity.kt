package br.com.caelum.twittelum

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelum.factory.ViewModelFactory
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.viewmodel.TweetViewModel
import kotlinx.android.synthetic.main.activity_lista_tweets.*

class ListaTweetsActivity : AppCompatActivity() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tweets)

        fab.setOnClickListener {
            val vaiProFormulario = Intent(this, TweetActivity::class.java)
            startActivity(vaiProFormulario)
        }

        viewModel.listar().observe(this, Observer {
            lista_tweets.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
        })

        lista_tweets.setOnItemClickListener { adapterView, view, position, id ->
            val tweet = adapterView.getItemAtPosition(position) as Tweet
            perguntaSeOCaraQuerDeletarO(tweet)
        }
    }

    private fun perguntaSeOCaraQuerDeletarO(tweet: Tweet) {
        AlertDialog.Builder(this)
            .setTitle("Ação Perigosa!!")
            .setMessage("Tem certeza que quer deletar essa parada?")
            .setPositiveButton("Sim") { _, _ -> viewModel.delete(tweet) }
            .setNegativeButton("Não", null)
            .setNeutralButton("Será o benedito?", null)
            .show()
    }

}