package ru.hivislav.educationproject.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.hivislav.educationproject.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {

    fun initList(list: List<GithubUser>)
}
