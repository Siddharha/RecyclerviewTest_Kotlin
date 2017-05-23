package `in`.creativelizard.recyclerviewtest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_cell.view.*

import java.util.ArrayList

/**
 * Created by siddhartha on 23/5/17.
 */

internal class MyAdapter(private val arrayList: ArrayList<MyItem>,
                         private val context: Context,
                         private val layout: Int) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(items: MyItem) {
            itemView.tvName.text = items.name
            itemView.tvNumber.text = items.number
        }
    }
}
