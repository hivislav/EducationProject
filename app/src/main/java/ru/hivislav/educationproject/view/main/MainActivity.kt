package ru.hivislav.educationproject.view.main

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.hivislav.educationproject.MyApplication
import ru.hivislav.educationproject.R
import ru.hivislav.educationproject.databinding.ActivityMainBinding
import ru.hivislav.educationproject.presenter.MainPresenter
import ru.hivislav.educationproject.utils.OnBackPressedListener

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.containerMain)
    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { MainPresenter(MyApplication.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        MyApplication.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        MyApplication.instance.navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager
            .fragments.forEach { currentFragment ->
                if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()) {
                    return
                }
            }
        presenter.onBackPressed()
    }
}