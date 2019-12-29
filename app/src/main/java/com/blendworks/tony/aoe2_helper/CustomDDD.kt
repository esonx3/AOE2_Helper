package com.blendworks.tony.aoe2_helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class CustomDDD(context: Context, internal var Names: Array<String>, internal var images: IntArray) : ArrayAdapter<String>(context, R.layout.dd_menu, Names) {


    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row = inflater.inflate(R.layout.dd_menu, null)
        val tw = row.findViewById<View>(R.id.txtDropDownLabel) as TextView
        val iv = row.findViewById<View>(R.id.imgDropDownMenuIcon) as ImageView
        tw.text = Names[position]
        iv.setImageResource(images[position])


        return row
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row = inflater.inflate(R.layout.dd_menu, null)
        val tw = row.findViewById<View>(R.id.txtDropDownLabel) as TextView
        val iv = row.findViewById<View>(R.id.imgDropDownMenuIcon) as ImageView
        tw.text = Names[position]
        iv.setImageResource(images[position])

        return row
    }
}