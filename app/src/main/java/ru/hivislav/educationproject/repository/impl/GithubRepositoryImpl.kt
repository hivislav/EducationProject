package ru.hivislav.educationproject.repository.impl

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import ru.hivislav.educationproject.model.GithubUser
import ru.hivislav.educationproject.repository.GithubRepository
import java.util.concurrent.TimeUnit

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

    override fun getUsers(): Single<List<GithubUser>> {
        return Single
            .create<List<GithubUser>> {
            it.onSuccess(repositories)
        }
    }
}