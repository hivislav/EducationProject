package ru.hivislav.educationproject.view.userslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.hivislav.educationproject.R
import ru.hivislav.educationproject.model.GithubUser

class UserAdapter(): RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        return GithubUserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_user, parent, false))
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val viewHolderLogin by lazy { itemView.findViewById<TextView>(R.id.viewHolderUserLogin) }

        fun bind(item: GithubUser) = with(item) {
            viewHolderLogin.text = login
        }
    }
}