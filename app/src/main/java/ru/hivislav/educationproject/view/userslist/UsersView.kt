package ru.hivislav.educationproject.view.userslist

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.hivislav.educationproject.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView: MvpView {

    fun initList(list: List<GithubUser>)
}
