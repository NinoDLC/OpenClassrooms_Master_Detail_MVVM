package fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail

import androidx.annotation.MainThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentMailIdRepository @Inject constructor() {
    private val currentIdMutableSharedFlow = MutableSharedFlow<String>(replay = 1)
    val currentIdFlow: Flow<String> = currentIdMutableSharedFlow

    @MainThread
    fun setCurrentId(currentId: String) {
        currentIdMutableSharedFlow.tryEmit(currentId)
    }
}