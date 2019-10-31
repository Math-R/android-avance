package com.example.androidavance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class TextViewHolder(val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)

class TextAdapter(private val game: IGame) : androidx.recyclerview.widget.RecyclerView.Adapter<TextViewHolder>() {

    override fun getItemCount(): Int {
        return game.games.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.list_item, parent, false)
        return TextViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val game: Game = game.games[position];
        holder.view.textView.text = game.name;
        Picasso.get().load(game.img).into(holder.view.image);
        holder.view.setOnClickListener{
            this.game.open(game);
        }
    }
}

interface IGame {
    val games: Array<Game>
    fun open (game: Game)

}
