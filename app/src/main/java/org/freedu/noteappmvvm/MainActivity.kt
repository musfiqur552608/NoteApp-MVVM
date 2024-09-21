package org.freedu.noteappmvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.freedu.noteappmvvm.adapter.TodoAdapter
import org.freedu.noteappmvvm.databinding.ActivityMainBinding
import org.freedu.noteappmvvm.databinding.ItemTodoBinding
import org.freedu.noteappmvvm.viewModel.TodoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val todoViewModel:TodoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        todoViewModel.todoItems.observe(this, Observer {
            binding.recyclerView.adapter = TodoAdapter(it)
        })

    }
}