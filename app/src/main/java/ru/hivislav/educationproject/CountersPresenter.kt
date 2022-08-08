package ru.hivislav.educationproject

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onCounterClick(id: Int) {
        when(id) {
            BUTTON_ONE_ID -> {
                val newValue = model.next(DATA_POSITION_FOR_BUTTON_ONE)
                view.setText(newValue.toString(), DATA_POSITION_FOR_BUTTON_ONE)
            }
            BUTTON_TWO_ID -> {
                val newValue = model.next(DATA_POSITION_FOR_BUTTON_TWO)
                view.setText(newValue.toString(), DATA_POSITION_FOR_BUTTON_TWO)
            }
            BUTTON_THREE_ID -> {
                val newValue = model.next(DATA_POSITION_FOR_BUTTON_THREE)
                view.setText(newValue.toString(), DATA_POSITION_FOR_BUTTON_THREE)
            }
        }
    }
}