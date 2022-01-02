package fr.delcey.openclassrooms_master_detail_mvvm.data.mail

data class MailEntity(
    val id: String,
    val title: String,
    val message: String,
    val from: String,
    val to: List<String>
)