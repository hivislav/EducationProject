package ru.hivislav.educationproject

import moxy.MvpPresenter
import ru.hivislav.educationproject.repository.GithubRepository
import ru.hivislav.educationproject.repository.impl.CountersRepository
import ru.hivislav.educationproject.view.MainView

class CountersPresenter(
    private val repository: GithubRepository
): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }
}