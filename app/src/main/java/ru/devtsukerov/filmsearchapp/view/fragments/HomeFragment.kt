package ru.devtsukerov.filmsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.devtsukerov.filmsearchapp.databinding.FragmentHomeBinding
import ru.devtsukerov.filmsearchapp.utils.AnimationHelper
import ru.devtsukerov.filmsearchapp.view.MainActivity
import ru.devtsukerov.filmsearchapp.domain.Film

import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.homeFragmentRoot, requireActivity(), 1)


        //находим наш RV
        binding.mainRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })

            adapter = filmsAdapter

            layoutManager = LinearLayoutManager(requireContext())

            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

        filmsAdapter.addItems(filmsDataBase)

        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String?): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText?.isEmpty() == true) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                    val result = filmsDataBase.filter {
                        //Чтобы все работало правильно, нужно и запрос, и имя фильма приводить к нижнему регистру
                        it.title.toLowerCase(Locale.getDefault()).contains(newText?.toLowerCase(Locale.getDefault())
                            .toString())
                    }
                    //Добавляем в адаптер
                    filmsAdapter.addItems(result)
                    return true
            }
        })
    }


}