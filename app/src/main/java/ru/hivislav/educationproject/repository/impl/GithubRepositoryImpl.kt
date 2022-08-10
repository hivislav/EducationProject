package ru.hivislav.educationproject.repository.impl

import ru.hivislav.educationproject.model.GithubUser
import ru.hivislav.educationproject.repository.GithubRepository

class GithubRepositoryImpl: GithubRepository {

    private val repositories = listOf(
        GithubUser("Andrey"),
        GithubUser("Vasily"),
        GithubUser("Victor"),
        GithubUser("Maria"),
        GithubUser("Anton"),
        GithubUser("Larisa"),
        GithubUser("Evgraf"),
        GithubUser("Mihail"),
        GithubUser("Alena"),
        GithubUser("Olga"),
        GithubUser("Ksenia"),
        GithubUser("Alex")
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }
}