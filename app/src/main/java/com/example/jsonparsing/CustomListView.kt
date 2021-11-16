package com.example.jsonparsing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomListView(context: Context,arrayList: ArrayList<JsonDataModel>):BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<JsonDataModel>

    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails=arrayList
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View

            view = this.layoutInflater.inflate(R.layout.layoutlistview,p2, false)

           val tvid=view.findViewById<TextView>(R.id.tvId)
            val tvname=view.findViewById<TextView>(R.id.tvName)
            val tvdegree=view.findViewById<TextView>(R.id.tvdegree)
tvid.setText(arrayListDetails.get(p0).id)
            tvname.setText(arrayListDetails.get(p0).name)
            tvdegree.setText(arrayListDetails.get(p0).degree)

        return view
    }

    override fun getItem(p0: Int): Any {
        return arrayListDetails.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }


}