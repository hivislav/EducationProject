package ru.hivislav.educationproject.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.hivislav.educationproject.CountersPresenter
import ru.hivislav.educationproject.databinding.ActivityMainBinding
import ru.hivislav.educationproject.model.GithubUser
import ru.hivislav.educationproject.repository.impl.CountersRepository
import ru.hivislav.educationproject.repository.impl.GithubRepositoryImpl

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val adapter = UserAdapter()

    private val presenter by moxyPresenter { CountersPresenter(GithubRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerViewGithubUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            //установка для подрузки определенного количества item'ов в кэш
            recyclerViewGithubUsers.setItemViewCacheSize(2)
            recyclerViewGithubUsers.adapter = adapter
            recyclerViewGithubUsers.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }
}