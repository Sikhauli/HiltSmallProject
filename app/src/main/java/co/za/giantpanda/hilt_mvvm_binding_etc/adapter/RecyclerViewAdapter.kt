package co.za.giantpanda.hilt_mvvm_binding_etc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.za.giantpanda.hilt_mvvm_binding_etc.R
import co.za.giantpanda.hilt_mvvm_binding_etc.db.RepositoriesData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_list_view.view.imageView
import kotlinx.android.synthetic.main.recycler_list_view.view.newsDesc
import kotlinx.android.synthetic.main.recycler_list_view.view.newsHeadLine

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

  private lateinit var listData: List<RepositoriesData>
  fun setListData(listData: List<RepositoriesData>){
    this.listData = listData
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {

    val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_view, parent, false)
    return MyViewHolder(view)
  }

  override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
      holder.bind(listData[position])
  }

  override fun getItemCount(): Int {
    return listData.size

  }

  class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imageView = view.imageView
    val newsHeadLine = view.newsHeadLine
    val newsDesc = view.newsDesc

    fun bind(data : RepositoriesData){
        newsDesc.text = data.description
        newsHeadLine.text = data.name

      Glide.with(imageView)
        .load(data.owner?.avatar_url)
        .into(imageView)

    }

  }

}