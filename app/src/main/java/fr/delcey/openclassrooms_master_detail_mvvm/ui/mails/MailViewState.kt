package fr.delcey.openclassrooms_master_detail_mvvm.ui.mails

data class MailViewState(
    val id: String,
    val title: String,
    val onMailClicked: () -> Unit,
)
