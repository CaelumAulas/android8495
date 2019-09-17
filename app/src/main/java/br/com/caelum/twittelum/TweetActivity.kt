package br.com.caelum.twittelum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelum.factory.ViewModelFactory
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.viewmodel.TweetViewModel
import kotlinx.android.synthetic.main.activity_tweet.*
import java.io.File


class TweetActivity : AppCompatActivity() {

    private val resultadoCameraRC: Int = 123

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tweet_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.btn_salvar -> publicaTweet()
            R.id.btn_camera -> tirarFoto()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun tirarFoto() {
        val vaiPraCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val caminhoFoto = defineCaminhoDaFoto()
        vaiPraCamera.putExtra(MediaStore.EXTRA_OUTPUT, caminhoFoto)

        startActivityForResult(vaiPraCamera, resultadoCameraRC)
    }

    private fun defineCaminhoDaFoto(): Uri {
        val caminho = "${getExternalFilesDir("fotos")}/${System.currentTimeMillis()}.jpg"
        val arquivo = File(caminho)

        return FileProvider.getUriForFile(this, "br.com.caelum.fotos", arquivo)
    }

    private fun publicaTweet() {
        val mensagem = mensagem.text.toString()
        val tweet = Tweet(mensagem)

        viewModel.salvar(tweet)

        Toast.makeText(this, "tweet: $tweet", Toast.LENGTH_LONG).show()
        finish()
    }


}
