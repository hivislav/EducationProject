package ru.hivislav.educationproject.view.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.hivislav.educationproject.MyApplication
import ru.hivislav.educationproject.databinding.FragmentUserDetailsBinding
import ru.hivislav.educationproject.databinding.FragmentUsersListBinding
import ru.hivislav.educationproject.model.GithubUser
import ru.hivislav.educationproject.presenter.UserDetailsPresenter
import ru.hivislav.educationproject.presenter.UsersPresenter
import ru.hivislav.educationproject.repository.impl.GithubRepositoryImpl
import ru.hivislav.educationproject.utils.OnBackPressedListener

const val USER_DETAILS_EXTRA = "USER_DETAILS_EXTRA"

class UserDetailsFragment: MvpAppCompatFragment(), UserDetailsView, OnBackPressedListener {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserDetailsPresenter(MyApplication.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(USER_DETAILS_EXTRA)?.let {
            binding.userDetailsLogin.text = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun getInstance(login: String): UserDetailsFragment {
            val fragment = UserDetailsFragment()
            val bundle = Bundle().apply {
                putString(USER_DETAILS_EXTRA, login)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()
}