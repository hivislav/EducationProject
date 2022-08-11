package ru.hivislav.educationproject.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import ru.hivislav.educationproject.navigation.UserDetailsScreen
import ru.hivislav.educationproject.repository.GithubRepository
import ru.hivislav.educationproject.view.userslist.UsersView
import java.util.concurrent.TimeUnit

class UsersPresenter(
    private val repository: GithubRepository,
    private val router: Router
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showProgressBar()
        repository.getUsers()
            .delay(2000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {
                viewState.initList(it)
                viewState.hideProgressBar()
            },
            {

            }
        )
    }

    fun openUserDetailsFragment(login: String) {
        router.navigateTo(UserDetailsScreen(login))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}