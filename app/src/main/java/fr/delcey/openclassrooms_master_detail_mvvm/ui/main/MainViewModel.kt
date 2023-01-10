package fr.delcey.openclassrooms_master_detail_mvvm.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail.CurrentMailIdRepository
import fr.delcey.openclassrooms_master_detail_mvvm.ui.utils.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    currentMailIdRepository: CurrentMailIdRepository
) : ViewModel() {

    private var isTablet: Boolean = false

    val navigateSingleLiveEvent = SingleLiveEvent<MainViewAction>()

    init {
        navigateSingleLiveEvent.addSource(currentMailIdRepository.currentIdLiveData) {
            if (!isTablet) {
                navigateSingleLiveEvent.setValue(MainViewAction.NavigateToDetailActivity)
            }
        }
    }

    fun onResume(isTablet: Boolean) {
        this.isTablet = isTablet
    }
}