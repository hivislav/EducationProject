package ru.hivislav.educationproject.view.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.hivislav.educationproject.MyApplication
import ru.hivislav.educationproject.databinding.FragmentUsersListBinding
import ru.hivislav.educationproject.model.GithubUser
import ru.hivislav.educationproject.presenter.UsersPresenter
import ru.hivislav.educationproject.repository.impl.GithubRepositoryImpl
import ru.hivislav.educationproject.utils.OnBackPressedListener
import ru.hivislav.educationproject.utils.hide
import ru.hivislav.educationproject.utils.show

class UsersListFragment: MvpAppCompatFragment(), UsersView, OnBackPressedListener {

    private val adapter = UserAdapter(object: OnItemClickListener{
        override fun onItemClick(login: String) {
            presenter.openUserDetailsFragment(login)
        }
    } )

    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UsersPresenter(GithubRepositoryImpl(), MyApplication.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerViewGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            //установка для подгрузки определенного количества item'ов в кэш
            recyclerViewGithubUsers.setItemViewCacheSize(2)
            recyclerViewGithubUsers.adapter = adapter
            recyclerViewGithubUsers.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun getInstance(): UsersListFragment {
            return UsersListFragment()
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun showProgressBar() {
        binding.progressBar.show()
    }

    override fun hideProgressBar() {
        binding.progressBar.hide()
    }

    override fun onBackPressed() = presenter.onBackPressed()
}