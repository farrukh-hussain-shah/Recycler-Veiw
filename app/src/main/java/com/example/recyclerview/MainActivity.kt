package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapter.ExampleAdapter
import com.example.recyclerview.Model.ExampleItem

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExampleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList=generateList(100)
        adapter=ExampleAdapter(this,exampleList)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


    }


    private fun generateList(size:Int):MutableList<ExampleItem>{
        val list = mutableListOf<ExampleItem>()
        for (i in 0  until  size){//Remember when you enter util then you not need to add "<="
            list.add(ExampleItem("Title $i", "Description $i"))
        }
        return list
    }

}