package ru.hivislav.educationproject

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onCounterClick(id: Int) {
        when(id) {
            R.id.btnNumber1 -> {
                val newValue = model.next(DATA_POSITION_FOR_BUTTON_ONE)
                view.setText(newValue.toString(), DATA_POSITION_FOR_BUTTON_ONE)
            }
            R.id.btnNumber2 -> {
                val newValue = model.next(DATA_POSITION_FOR_BUTTON_TWO)
                view.setText(newValue.toString(), DATA_POSITION_FOR_BUTTON_TWO)
            }
            R.id.btnNumber3 -> {
                val newValue = model.next(DATA_POSITION_FOR_BUTTON_THREE)
                view.setText(newValue.toString(), DATA_POSITION_FOR_BUTTON_THREE)
            }
        }
    }
}