package fr.delcey.openclassrooms_master_detail_mvvm.ui.mails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail.CurrentMailIdRepository
import fr.delcey.openclassrooms_master_detail_mvvm.data.mail.MailRepository
import javax.inject.Inject

@HiltViewModel
class MailsViewModel @Inject constructor(
    mailRepository: MailRepository,
    private val currentMailIdRepository: CurrentMailIdRepository
) : ViewModel() {

    val mailsLiveData: LiveData<List<MailViewState>> = mailRepository.getAllMailLiveData().map { mails ->
        mails.map {
            MailViewState(
                it.id,
                it.title
            )
        }
    }

    fun onMailClicked(id: String) {
        currentMailIdRepository.setCurrentId(id)
    }
}