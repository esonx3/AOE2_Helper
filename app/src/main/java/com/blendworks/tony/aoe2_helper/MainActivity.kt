package com.blendworks.tony.aoe2_helper

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.es.mewphone.common.CustomDropDownAdapter
import android.R.attr.data
import android.net.Uri
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import java.io.IOException
import android.content.res.XmlResourceParser




class MainActivity : AppCompatActivity(),View.OnClickListener,CivInfo.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val ImageIDs: IntArray = intArrayOf(R.drawable.aaztecs, R.drawable.bberbers, R.drawable.bbritons, R.drawable.bbulgarians
            , R.drawable.burmese, R.drawable.byzantines, R.drawable.celts, R.drawable.chinese, R.drawable.cumans, R.drawable.ethiopians
            , R.drawable.franks, R.drawable.goths, R.drawable.huns, R.drawable.incas, R.drawable.indians, R.drawable.italians
            , R.drawable.japanese, R.drawable.khmer, R.drawable.koreans, R.drawable.lithuanians, R.drawable.magyars
            , R.drawable.malay, R.drawable.malians, R.drawable.mayans, R.drawable.mongols, R.drawable.persians
            , R.drawable.portuguese, R.drawable.saracens, R.drawable.slavs, R.drawable.spanish, R.drawable.tatars
            , R.drawable.teutons, R.drawable.turks, R.drawable.vietnamese, R.drawable.vikings)
    var parsedCivs: List<ParsedCivs>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)

        //var parsedCivs: List<ParsedCivs>? = null

        try {
            val parser = ParseCivInfo()
            //val istream = assets.open("civ_data.xml")
            //val istream =resources.getXml(R.xml.civ_data)

            val res = getResources()
            val xpp = res.getXml(R.xml.civ_data)

           //val istream = resources.getXml(R.xml.civ_data)
            parsedCivs = parser.parse(xpp)
            xpp.close()

            System.out.println("selector")
            System.out.println("Civ1: " + parsedCivs!![0].name)

            //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, employees)
            //listView.adapter = adapter
        } catch (e: Exception) {
            //e.printStackTrace()
        }
        System.out.println("HERE")
        if(parsedCivs != null) {
            System.out.println("first fragment")
            var lol:ParsedCivs = parsedCivs!![0]
            System.out.println("name" + lol.name)
            val InfoFragment = CivInfo.newInstance(lol)
            val Smanager = supportFragmentManager
            val trans = Smanager.beginTransaction()
            //val Args = Bundle()
            //Args.putInt("CivID", position)
            //InfoFragment.arguments
            trans.replace(R.id.fragment_holder, InfoFragment)
            trans.addToBackStack(null)
            trans.commit()
        }


        val languages = resources.getStringArray(R.array.civilizations)

        //val adapter = ArrayAdapter<String>(this, R.layout.dd_menu, R.id.txtDropDownLabel, languages)

        val CustomAdapter = CustomDDD(this,languages,ImageIDs);

        //adapter.setDropDownViewResource(R.layout.dd_menu)
        CustomAdapter.setDropDownViewResource(R.layout.dd_menu)

        val spinner = findViewById<Spinner>(R.id.civs_select_spinner)
        //spinner.adapter = adapter
        spinner.adapter = CustomAdapter;



        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if(Selected != position) {
                    Selected = position
                    Toast.makeText(this@MainActivity, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
                    //DisplayInfo( CivInfo())

                    //val InfoFragment = CivInfo()
                    System.out.println("selector")
                    System.out.println("Civ1: " + parsedCivs!![position].name)

                    if(parsedCivs != null) {
                        var lol:ParsedCivs = parsedCivs!![position]
                        System.out.println("name" + lol.name)
                        val InfoFragment = CivInfo.newInstance(lol)

                        val Smanager = supportFragmentManager
                        val trans = Smanager.beginTransaction()
                        //val Args = Bundle()
                        //Args.putInt("CivID", position)
                        //InfoFragment.arguments
                        trans.replace(R.id.fragment_holder, InfoFragment)
                        trans.addToBackStack(null)
                        trans.commit()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }
    public var Selected = -1
    //var fragment: Fragment? = null
    fun DisplayInfo(fragment: Fragment){
        if (fragment != null){
            val Ftransaction = supportFragmentManager.beginTransaction()
            Ftransaction.replace(R.id.FragmentInfo,fragment)
            Ftransaction.commit()
        }
    }
    override fun onClick(p0: View?) {
        when (p0?.id) {


        }
    }
}
