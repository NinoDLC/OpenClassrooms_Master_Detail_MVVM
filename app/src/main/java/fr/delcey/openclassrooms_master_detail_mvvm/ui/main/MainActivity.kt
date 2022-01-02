package fr.delcey.openclassrooms_master_detail_mvvm.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import fr.delcey.openclassrooms_master_detail_mvvm.R
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.MainActivityBinding
import fr.delcey.openclassrooms_master_detail_mvvm.ui.detail.DetailActivity
import fr.delcey.openclassrooms_master_detail_mvvm.ui.detail.DetailFragment
import fr.delcey.openclassrooms_master_detail_mvvm.ui.list.MailsFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainFlContainerList.id, MailsFragment())
                .commitNow()
        }

        if (binding.mainFlContainerDetail != null && supportFragmentManager.findFragmentById(binding.mainFlContainerDetail.id) == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    binding.mainFlContainerDetail.id,
                    DetailFragment()
                )
                .commitNow()
        }

        viewModel.navigateSingleLiveEvent.observe(this) {
            when (it) {
                MainViewAction.NavigateToDetailActivity -> startActivity(Intent(this, DetailActivity::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.onConfigurationChanged(resources.getBoolean(R.bool.isTablet))
    }
}