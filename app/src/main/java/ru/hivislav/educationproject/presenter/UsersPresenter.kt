package ru.hivislav.educationproject.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.hivislav.educationproject.repository.GithubRepository
import ru.hivislav.educationproject.view.userslist.UsersView

class UsersPresenter(
    private val repository: GithubRepository,
    private val router: Router
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}