package ru.hivislav.educationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.hivislav.educationproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber1)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber2)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber3)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, dataPosition: Int) {
        with(binding) {
            when (dataPosition) {
                DATA_POSITION_FOR_BUTTON_ONE -> tvText1.text = counter
                DATA_POSITION_FOR_BUTTON_TWO -> tvText2.text = counter
                DATA_POSITION_FOR_BUTTON_THREE -> tvText3.text = counter
            }
        }
    }
}