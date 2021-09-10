package ru.devtsukerov.filmsearchapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.film_item.view.*
import ru.devtsukerov.filmsearchapp.domain.Film

class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilmViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> {
                holder.bind(items[position])

                holder.itemView.item_container.setOnClickListener {
                    clickListener.click(items[position])
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(list: List<Film>) {

        items.clear()

        items.addAll(list)

        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun click(film: Film)
    }
}