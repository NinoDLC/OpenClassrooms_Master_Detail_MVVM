package fr.delcey.openclassrooms_master_detail_mvvm.ui.mails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail.CurrentMailIdRepository
import fr.delcey.openclassrooms_master_detail_mvvm.data.mail.MailRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MailsViewModel @Inject constructor(
    mailRepository: MailRepository,
    private val currentMailIdRepository: CurrentMailIdRepository
) : ViewModel() {

    val mailsLiveData: LiveData<List<MailViewState>> = liveData(Dispatchers.IO) {
        mailRepository.emailsStateFlow.collect { mails ->
            emit(
                mails.map {
                    MailViewState(
                        id = it.id,
                        title = it.title,
                        onMailClicked = {
                            currentMailIdRepository.setCurrentMailId(it.id)
                        },
                    )
                }
            )
        }
    }
}