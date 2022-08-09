package ru.hivislav.educationproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            buttonNumberOne.setOnClickListener {
                presenter.onClickButtonOne()
            }
            buttonNumberTwo.setOnClickListener {
                presenter.onClickButtonTwo()
            }
            buttonNumberThree.setOnClickListener {
                presenter.onClickButtonThree()
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setTextCounterOne(counter: String) = with(binding) {
        textViewOne.text = counter
    }

    override fun setTextCounterTwo(counter: String) = with(binding) {
        textViewTwo.text = counter
    }

    override fun setTextCounterThree(counter: String) = with(binding) {
        textViewThree.text = counter
    }
}