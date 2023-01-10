package fr.delcey.openclassrooms_master_detail_mvvm.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import fr.delcey.openclassrooms_master_detail_mvvm.R
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.DetailFragmentBinding
import fr.delcey.openclassrooms_master_detail_mvvm.ui.utils.viewBinding

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val binding by viewBinding { DetailFragmentBinding.bind(it) }
    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.detailLiveData.observe(viewLifecycleOwner) {
            binding.detailTextViewFromTitle.isVisible = it.areTitlesVisible
            binding.detailTextViewTitleTitle.isVisible = it.areTitlesVisible
            binding.detailTextViewToTitle.isVisible = it.areTitlesVisible

            binding.detailTextViewTitleContent.text = it.title
            binding.detailTextViewFromContent.text = it.from
            binding.detailTextViewToContent.text = it.to
            binding.detailTextViewMessage.text = it.message
        }
    }
}