package com.example.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val bundle=intent.extras
        foodimage.setImageResource(bundle!!.getInt("image"))
        tvname.text=bundle.getString("name")
        tvdes.text=bundle.getString("des")

    }
}
