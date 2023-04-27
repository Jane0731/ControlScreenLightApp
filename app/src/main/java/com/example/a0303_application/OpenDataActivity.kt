package com.example.a0303_application

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a0303_application.databinding.ActivityOpenDataBinding
import retrofit2.Call
import retrofit2.Response

class OpenDataActivity : AppCompatActivity() {
    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityOpenDataBinding
    private var uvList: MutableList<UVData.Records> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOpenDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getData.setOnClickListener{
            getData()
        }

    }
    private fun getData(){
        UVApi
            .retrofitService
            .getUV(key = "b87b12bb-1930-4962-8fa1-aa479805a392")
            .enqueue(object:retrofit2.Callback<UVData>{
                override fun onResponse(call: Call<UVData>, response: Response<UVData>) {
                    Log.d("success",response.toString())
                    if(response.isSuccessful){
                        response.body()?.records?.forEach {
                            Log.d("api",it.toString())
                            uvList.add(it)
                        }
                    }
                    for (item in uvList) {
                        Log.d("country",item.county)
                        adapter=MainAdapter(uvList)
                        binding.UVData.layoutManager= LinearLayoutManager(this@OpenDataActivity)
                        binding.UVData.adapter=adapter
                    }
                }

                override fun onFailure(call: Call<UVData>, t: Throwable) {
                    Log.e("fail",t.toString())
                }

            })
    }
}
class MainAdapter(private val list:MutableList<UVData.Records>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.activity_uvdata,parent,false)
        return  ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val uvHolder=(holder as ItemViewHolder)
        uvHolder.setCountry(list[position].county)
        uvHolder.setTime(list[position].publishtime)
        uvHolder.setUV(list[position].uvi)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
private class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var countryTextView:TextView=itemView.findViewById(R.id.country)
    var timeTextView:TextView=itemView.findViewById(R.id.time)
    var uvTextView:TextView=itemView.findViewById(R.id.uv)

    fun setCountry(country:String){
        countryTextView.text=country
    }
    fun setTime(time:String){
        timeTextView.text=time
    }
    fun setUV(uv:String){
        uvTextView.text=uv
    }
}