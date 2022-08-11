package ru.hivislav.educationproject.repository

import io.reactivex.rxjava3.core.Single
import ru.hivislav.educationproject.model.GithubUser

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}