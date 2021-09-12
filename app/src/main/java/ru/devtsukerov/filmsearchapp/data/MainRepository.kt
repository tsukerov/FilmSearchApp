package ru.devtsukerov.filmsearchapp.data

import ru.devtsukerov.filmsearchapp.R
import ru.devtsukerov.filmsearchapp.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film("Back To The Future", R.drawable.backtothefuture, "This should be a description",8.5f),
        Film("Fight Club", R.drawable.fightclub, "This should be a description",8.8f),
        Film("Inception", R.drawable.inception, "This should be a description",8.8f),
        Film("Matrix", R.drawable.matrix, "This should be a description",8.7f),
        Film("Pulp Fiction", R.drawable.pulpfiction, "This should be a description",8.9f),
        Film(
            "Shawshank Redemption",
            R.drawable.shawshank_redemption,
            "This should be a description",9.3f
        ),
        Film("Terminator 2", R.drawable.terminator2, "This should be a description",8.5f),
        Film("Toy Story", R.drawable.toystory, "This should be a description",8.3f)
    )
}