package fr.delcey.openclassrooms_master_detail_mvvm.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.DetailFragmentBinding

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.detailLiveData.observe(this) {
            binding.detailTvFromTitle.isVisible = it.areTitlesVisible
            binding.detailTvTitleTitle.isVisible = it.areTitlesVisible
            binding.detailTvToTitle.isVisible = it.areTitlesVisible

            binding.detailTvTitleContent.text = it.title
            binding.detailTvFromContent.text = it.from
            binding.detailTvToContent.text = it.to
            binding.detailTvMessage.text = it.message
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}