package ru.hivislav.educationproject.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.hivislav.educationproject.navigation.UsersScreen
import ru.hivislav.educationproject.repository.GithubRepository
import ru.hivislav.educationproject.view.userdetails.UserDetailsView
import ru.hivislav.educationproject.view.userslist.UsersView

class UserDetailsPresenter(
    private val router: Router
): MvpPresenter<UserDetailsView>() {

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }
}