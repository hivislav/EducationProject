package ru.hivislav.educationproject.repository

import ru.hivislav.educationproject.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}