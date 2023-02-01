package fr.delcey.openclassrooms_master_detail_mvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail.CurrentMailIdRepository
import fr.delcey.openclassrooms_master_detail_mvvm.data.mail.MailRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    currentMailIdRepository: CurrentMailIdRepository,
    private val mailRepository: MailRepository
) : ViewModel() {

    val detailLiveData: LiveData<DetailViewState> = liveData(Dispatchers.IO) {
        currentMailIdRepository.currentMailIdFlow.collect { mailId ->
            if (mailId != null) {
                val mailEntity = mailRepository.getMailById(mailId)
                if (mailEntity != null) {
                    emit(
                        DetailViewState(
                            title = mailEntity.title,
                            from = mailEntity.from,
                            to = mailEntity.to.joinToString(separator = ",\n"),
                            message = mailEntity.message,
                            areTitlesVisible = true
                        )
                    )
                }
            }
        }
    }
}