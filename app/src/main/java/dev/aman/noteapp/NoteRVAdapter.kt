package dev.aman.noteapp

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(private val context:Context, val listener :INotesRVAdapter):RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {
    private val allNotes=ArrayList<Note>()
    inner class NoteViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
       val textView: TextView =itemView.findViewById<TextView>(R.id.text)
       val deleteButton: ImageView =itemView.findViewById<ImageView>(R.id.deleteButton)


    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
   val currentNote=allNotes[position]
        holder.textView.text=currentNote.text
    }

    override fun getItemCount(): Int {
   return allNotes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder= NoteViewHolder( LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClick(allNotes[viewHolder.adapterPosition])

        }
        return viewHolder
    }
    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}
interface INotesRVAdapter {
    fun onItemClick(note:Note){


    }


}