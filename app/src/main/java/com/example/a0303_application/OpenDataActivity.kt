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
    private var uvList: MutableList<BusData> = mutableListOf()
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
            .getUV(format="JSON")
            .enqueue(object:retrofit2.Callback<List<BusData>>{
                override fun onFailure(call: Call<List<BusData>>, t: Throwable) {
                    Log.e("fail",t.toString())
                }
                override fun onResponse(
                    call: Call<List<BusData>>,
                    response: Response<List<BusData>>
                ) {
                    if(response.isSuccessful){
                        response.body()?.forEach {
                            Log.d("api",it.toString())
                            uvList.add(it)
                        }
                    }
                    for (item in uvList) {
                        Log.d("country",item.StopName.Zh_tw)
                        adapter=MainAdapter(uvList)
                        binding.UVData.layoutManager= LinearLayoutManager(this@OpenDataActivity)
                        binding.UVData.adapter=adapter
                    }
                }

            })
    }
}
class MainAdapter(private val list:MutableList<BusData>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.activity_uvdata,parent,false)
        return  ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val uvHolder=(holder as ItemViewHolder)
        uvHolder.setDirection("去程回程："+list[position].Direction)
        uvHolder.setStopName("站牌名字："+list[position].StopName.Zh_tw)
        uvHolder.setNextBusTime("下一班車時間："+list[position].NextBusTime)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
private class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var countryTextView:TextView=itemView.findViewById(R.id.country)
    var timeTextView:TextView=itemView.findViewById(R.id.time)
    var uvTextView:TextView=itemView.findViewById(R.id.uv)

    fun setDirection(direction:String){
        countryTextView.text=direction
    }
    fun setStopName(stopName:String){
        timeTextView.text=stopName
    }
    fun setNextBusTime(nextBusTime:String){
        uvTextView.text=nextBusTime
    }
}