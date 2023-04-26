package com.aysegulyilmaz.kotlinlandmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.aysegulyilmaz.kotlinlandmarkbook.databinding.ActivityDetailsBinding
import com.aysegulyilmaz.kotlinlandmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var landMarkList:ArrayList<LandMark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landMarkList = ArrayList<LandMark>()

        //Burada tek tek dizi oluşturmak yerine bir class oluşturup değerleri içine atmak daha mantıklı

        val pisa = LandMark("Pisa","Italy",R.drawable.pisa)
        val colosseum = LandMark("Colloseum","Italy",R.drawable.collesium)
        val eiffel = LandMark("Eiffel","France",R.drawable.eifel)
        val londonBridge = LandMark("London Bridge","UK",R.drawable.london)

        landMarkList.add(pisa)
        landMarkList.add(colosseum)
        landMarkList.add(eiffel)
        landMarkList.add(londonBridge)
        //Grid layout yan yana göster
        //Linear Layout alt alta göster
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landMarkAdapter = LandMarkAdapter(landMarkList)
        binding.recyclerView.adapter = landMarkAdapter
        /*
        //Adapter:Layout & Data (xml ile veri setini birleştirmek)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landMarkList.map { landMark -> landMark.name  })
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark",landMarkList.get(position))
            startActivity(intent)
        }*/
    }
}