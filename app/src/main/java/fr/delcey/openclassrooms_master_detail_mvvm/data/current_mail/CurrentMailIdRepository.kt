package fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentMailIdRepository @Inject constructor() {
    private val currentIdMutableLiveData = MutableLiveData<String>()
    val currentIdLiveData: LiveData<String> = currentIdMutableLiveData

    @MainThread
    fun setCurrentId(currentId: String) {
        currentIdMutableLiveData.value = currentId
    }
}