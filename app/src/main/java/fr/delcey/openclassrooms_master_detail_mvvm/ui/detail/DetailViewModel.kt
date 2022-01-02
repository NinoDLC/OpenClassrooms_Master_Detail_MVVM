package fr.delcey.openclassrooms_master_detail_mvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail.CurrentMailIdRepository
import fr.delcey.openclassrooms_master_detail_mvvm.data.mail.MailRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    currentMailIdRepository: CurrentMailIdRepository,
    private val mailRepository: MailRepository
) : ViewModel() {

    val detailLiveData: LiveData<DetailViewState> = currentMailIdRepository.currentIdLiveData.switchMap { id ->
        mailRepository.getMailByIdLiveData(id).map {
            DetailViewState(
                title = it.title,
                from = it.from,
                to = it.to.joinToString(separator = ",\n"),
                message = it.message,
                areTitlesVisible = true
            )
        }
    }
}