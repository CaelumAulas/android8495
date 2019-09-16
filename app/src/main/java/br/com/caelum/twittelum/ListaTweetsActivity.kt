package br.com.caelum.twittelum

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_lista_tweets.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tweets)

        val tweets = listOf<String>(
            "Tweet 1",
            "Tweet 2",
            "Tweet 3",
            "...",
            "Tweet 1",
            "Tweet 2",
            "Tweet 3",
            "...",
            "Tweet 1",
            "Tweet 2",
            "Tweet 3",
            "...",
            "Tweet 1",
            "Tweet 2",
            "Tweet 3",
            "..."
        )

        lista_tweets.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tweets)

        fab.setOnClickListener {
            Snackbar.make(lista_tweets, "Indo para o TweetActivity", Snackbar.LENGTH_LONG).show()

            val vaiProFormulario = Intent(this, MainActivity::class.java)
            startActivity(vaiProFormulario)
        }


    }
}