package com.project.laundryappui.menu.home.home_detail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.project.laundryappui.R

class HomeDetailActivity : AppCompatActivity() {
    private var buttonBack: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_detail)
        buttonBack = findViewById(R.id.button_back)
        buttonBack?.setOnClickListener(View.OnClickListener { view: View? -> onBackPressed() })
    }

}