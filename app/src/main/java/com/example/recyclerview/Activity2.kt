package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.TextView
import com.example.recyclerview.Utils.Contants
import com.example.recyclerview.Utils.Contants.Companion.KEY_TITLE

class Activity2 : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        titleTextView=findViewById(R.id.textView)
        descriptionTextView=findViewById(R.id.textView2)

        val data=intent.extras
        data?.let {
            titleTextView.text=it.getString(Contants.KEY_TITLE)
            descriptionTextView.text=it.getString(Contants.KEY_DESCRIPTION)
        }
    }
}