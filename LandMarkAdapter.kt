package com.aysegulyilmaz.kotlinlandmarkbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aysegulyilmaz.kotlinlandmarkbook.databinding.ActivityDetailsBinding
import com.aysegulyilmaz.kotlinlandmarkbook.databinding.RecyclerRowBinding
//bizim verilerimizi recyclerviewa taşımamız için landmarkliste ulaşabiliyor olmamız lazım bu da val landmarklist:ArrayList<landmark>) ile oluyor.

class LandMarkAdapter(val landMarkList: ArrayList<LandMark>) : RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder>() {
    class LandMarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
    //itemview yerine binding.root diyerek bir görünüm verebiliriz

    }
    //ViewHolder oluşturulduğunda ne olacak
    //parent recyclerviewın nereye bağlanacağı
    //attach to parent parenta bağliyim mi diye soruyo zaten bağlanacak sadece ilk napiyim diye soruyo
    //:LandmarkHolder kısmı oldupu için bu fonksiyon bizim bir tane landmarkholder döndürmemizi istiyor


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandMarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandMarkHolder(binding)
    }
    //hangi textte hangi veri kullanılıcak onu yazdığımız kısım
    override fun onBindViewHolder(holder: LandMarkHolder, position: Int) {
        holder.binding.recyclerViewText.text = landMarkList.get(position).name
        //tıklandığında ne olacağını yazıyoruz
        //holder.itemview tıklanılan görünümü vereceği için kullandık detailsactivitye gönderdik
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("landmark",landMarkList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }
    //kaç tane oluşturucaz bundan
    override fun getItemCount(): Int {
        return landMarkList.size
    }
}