package ru.hivislav.educationproject.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.hivislav.educationproject.view.userslist.UsersListFragment

object UsersScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UsersListFragment.getInstance()
    }
}