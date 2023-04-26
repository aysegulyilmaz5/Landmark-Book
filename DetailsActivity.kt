package com.aysegulyilmaz.kotlinlandmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aysegulyilmaz.kotlinlandmarkbook.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        //casting
        val selectedlandmark = intent.getSerializableExtra("landmark") as LandMark

        binding.nameText.text = selectedlandmark.name
        binding.countryText.text = selectedlandmark.country
        binding.imageView.setImageResource(selectedlandmark.image)
    }
}