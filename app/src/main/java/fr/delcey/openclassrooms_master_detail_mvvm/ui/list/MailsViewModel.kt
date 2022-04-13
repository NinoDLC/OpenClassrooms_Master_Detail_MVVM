package fr.delcey.openclassrooms_master_detail_mvvm.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail.CurrentMailIdRepository
import fr.delcey.openclassrooms_master_detail_mvvm.data.mail.MailRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MailsViewModel @Inject constructor(
    mailRepository: MailRepository,
    private val currentMailIdRepository: CurrentMailIdRepository
) : ViewModel() {

    val mailsLiveData: LiveData<List<MailViewState>> = mailRepository.getAllMailFlow().map { mails ->
        mails.map {
            MailViewState(
                it.id,
                it.title
            )
        }
    }.asLiveData()

    fun onMailClicked(id: String) {
        currentMailIdRepository.setCurrentId(id)
    }
}