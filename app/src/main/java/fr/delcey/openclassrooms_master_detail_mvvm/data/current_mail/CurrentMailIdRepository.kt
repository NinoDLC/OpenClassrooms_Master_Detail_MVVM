package fr.delcey.openclassrooms_master_detail_mvvm.data.current_mail

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentMailIdRepository @Inject constructor() {
    private val currentMailIdMutableSharedFlow = MutableStateFlow<String?>(null)
    val currentMailIdChannel = Channel<String>()
    val currentMailIdFlow: StateFlow<String?> = currentMailIdMutableSharedFlow.asStateFlow()

    fun setCurrentMailId(currentId: String) {
        currentMailIdMutableSharedFlow.value = currentId
        currentMailIdChannel.trySend(currentId)
    }
}