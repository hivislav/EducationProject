package ru.hivislav.educationproject

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onClickButtonOne(){
        val newValue = model.next(DATA_POSITION_FOR_BUTTON_ONE)
        view.setTextCounterOne(newValue.toString())
    }

    fun onClickButtonTwo(){
        val newValue = model.next(DATA_POSITION_FOR_BUTTON_TWO)
        view.setTextCounterTwo(newValue.toString())
    }

    fun onClickButtonThree(){
        val newValue = model.next(DATA_POSITION_FOR_BUTTON_THREE)
        view.setTextCounterThree(newValue.toString())
    }
}