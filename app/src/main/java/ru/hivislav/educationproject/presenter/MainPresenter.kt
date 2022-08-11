package ru.hivislav.educationproject.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.hivislav.educationproject.navigation.UsersScreen
import ru.hivislav.educationproject.view.main.MainView

class MainPresenter(
    private val router: Router
): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }
}