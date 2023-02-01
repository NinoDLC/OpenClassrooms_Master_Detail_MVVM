package fr.delcey.openclassrooms_master_detail_mvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail.CurrentMailIdRepository
import fr.delcey.openclassrooms_master_detail_mvvm.ui.utils.Event
import fr.delcey.openclassrooms_master_detail_mvvm.ui.utils.asLiveDataEvent
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    currentMailIdRepository: CurrentMailIdRepository
) : ViewModel() {

    private var isTablet: Boolean = false

    // Can't use viewModelScope.launch{}, because we would collect the flow even when user put the application on background
    val mainViewActionLiveData: LiveData<Event<MainViewAction>> =
        currentMailIdRepository.currentMailIdChannel.asLiveDataEvent(Dispatchers.IO) {
            if (!isTablet) {
                emit(MainViewAction.NavigateToDetailActivity)
            }
        }

    fun onResume(isTablet: Boolean) {
        this.isTablet = isTablet
    }
}