package fr.delcey.openclassrooms_master_detail_mvvm.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.DetailActivityBinding
import fr.delcey.openclassrooms_master_detail_mvvm.ui.utils.viewBinding

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val binding by viewBinding { DetailActivityBinding.inflate(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.detailFrameLayoutContainer.id, DetailFragment())
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