package com.example.kadai01

import android.icu.text.MessageFormat.format
import android.text.format.DateFormat.format
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import java.lang.String.format
import java.text.DateFormat
import java.text.MessageFormat.format

class KadaiAdapter(data: OrderedRealmCollection<Kadai>):
    RealmRecyclerViewAdapter<Kadai, KadaiAdapter.ViewHolder>(data, true) {

        init {
            setHasStableIds(true)
        }

    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell) {
        val title: TextView = cell.findViewById(android.R.id.text1)
        val id: TextView = cell.findViewById(android.R.id.text2)
        val pass: TextView = cell.findViewById(android.R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            KadaiAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val  view = inflater.inflate(android.R.layout.simple_list_item_2,
            parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kadai: Kadai? = getItem(position)
        holder.title.text = kadai?.title
        holder.id.text = kadai?.id
        holder.pass.text = kadai?.pass

    }

    override  fun getItemId(position: Int): Long {
        return (getItem(position)?.id ?: 0) as Long
    }
}