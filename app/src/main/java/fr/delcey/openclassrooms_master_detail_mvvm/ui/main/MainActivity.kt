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
import fr.delcey.openclassrooms_master_detail_mvvm.ui.mails.MailsFragment
import fr.delcey.openclassrooms_master_detail_mvvm.ui.utils.viewBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding { MainActivityBinding.inflate(it) }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainFrameLayoutContainerMails.id, MailsFragment())
                .commitNow()
        }

        val containerDetailsId = binding.mainFrameLayoutContainerDetail?.id
        if (containerDetailsId != null && supportFragmentManager.findFragmentById(containerDetailsId) == null) {
            supportFragmentManager.beginTransaction()
                .replace(containerDetailsId, DetailFragment())
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

        viewModel.onResume(resources.getBoolean(R.bool.isTablet))
    }
}