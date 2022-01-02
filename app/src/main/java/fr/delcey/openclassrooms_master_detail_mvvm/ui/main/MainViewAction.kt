package fr.delcey.openclassrooms_master_detail_mvvm.ui.main

sealed class MainViewAction {
    object NavigateToDetailActivity : MainViewAction()
}
