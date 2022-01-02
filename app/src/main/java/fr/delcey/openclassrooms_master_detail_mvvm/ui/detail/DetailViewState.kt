package fr.delcey.openclassrooms_master_detail_mvvm.ui.detail

data class DetailViewState(
    val title: String,
    val from: String,
    val to: String,
    val message: String,
    val areTitlesVisible: Boolean
)
