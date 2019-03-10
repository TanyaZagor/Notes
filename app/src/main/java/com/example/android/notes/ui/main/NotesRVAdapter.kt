package com.example.android.notes.ui.main

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.notes.R
import com.example.android.notes.data.entity.Note

class NotesRVAdapter (val onItemClick : ((Note) -> Unit)? = null)  : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(notes[position])

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView = itemView.findViewById<TextView>(R.id.tv_title)
        val textTextView = itemView.findViewById<TextView>(R.id.tv_text)

        fun bind(note: Note) = with(note) {
            titleTextView.text = title
            textTextView.text = text

            val background = when(color){
                Note.Color.WHITE -> R.color.color_white
                Note.Color.YELLOW -> R.color.color_yellow
                Note.Color.GREEN -> R.color.color_green
                Note.Color.BLUE -> R.color.color_blue
                Note.Color.RED -> R.color.color_red
                Note.Color.VIOLET -> R.color.color_violet
                Note.Color.PINK -> R.color.color_pink
            }
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, background))
            itemView.setOnClickListener {
                onItemClick?.invoke(note)
            }
        }
    }

}


