package fr.delcey.openclassrooms_master_detail_mvvm.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.DetailActivityBinding

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.detailFlContainer.id, DetailFragment())
                .commitNow()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            supportFinishAfterTransition()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}