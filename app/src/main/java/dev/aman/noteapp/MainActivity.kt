package dev.aman.noteapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.aman.noteapp.INotesRVAdapter


class MainActivity : AppCompatActivity() ,INotesRVAdapter{
    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val recyclerview=findViewById<RecyclerView>(R.id.aman)
        recyclerview.layoutManager=LinearLayoutManager(this)
        val adapter=NoteRVAdapter(this,this)
        recyclerview.adapter=adapter

        viewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[NoteViewModel ::class.java]
        viewModel.allNotes.observe(this, Observer{
           list->
            list?.let{

                adapter.updateList()
            }

             })







    }
    override fun onItemClicked(note:Note){
        viewModel.deleteNode(note)

    }

 
}
