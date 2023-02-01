package fr.delcey.openclassrooms_master_detail_mvvm.ui.mails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import fr.delcey.openclassrooms_master_detail_mvvm.R
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.MailsFragmentBinding
import fr.delcey.openclassrooms_master_detail_mvvm.ui.utils.viewBinding

@AndroidEntryPoint
class MailsFragment : Fragment(R.layout.mails_fragment) {

    private val binding by viewBinding { MailsFragmentBinding.bind(it) }
    private val viewModel by viewModels<MailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MailsAdapter()
        binding.mailsRecyclerView.adapter = adapter
        viewModel.mailsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}