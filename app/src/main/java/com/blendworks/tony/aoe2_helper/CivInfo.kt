package com.blendworks.tony.aoe2_helper

import android.content.Context
import android.content.res.XmlResourceParser
import android.net.Uri
import android.os.Bundle
import android.os.Debug
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
private const  val ARG_PARAM = "parsedCivs"
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CivInfo.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CivInfo.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CivInfo : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    //private lateinit var PC: ParsedCivs
    private var PC: ParsedCivs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            PC = it.getParcelable("plaz")
        }
    }
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //arguments?.let {
        //    param1 = it.getInt(ARG_PARAM1)
        //}
        System.out.println("Creating.. ..")
        //if ( arguments != null) {
            System.out.println("INITILIZED")
            PC = arguments!!.getParcelable("plaz")
        //}
    }*/




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val localView = inflater.inflate(R.layout.fragment_civ_info, container, false)
        System.out.println("here")
        localView.findViewById<TextView>(R.id.CivName).setText("" + PC?.name)
        localView.findViewById<TextView>(R.id.UU_name).setText("" + PC?.UU)
        localView.findViewById<TextView>(R.id.CB5).setText("" + PC?.IUT)
        localView.findViewById<TextView>(R.id.CB3).setText("" + PC?.CUT)
        localView.findViewById<TextView>(R.id.TB_Desc).setText("" + PC?.TeamBonus)

        var Lines = PC?.CivBonus?.split(';')

        var li = "* "

        Lines?.forEach {
            li += (it + System.getProperty ("line.separator") + "* ")
        }
        li = li.dropLast(2)


        localView.findViewById<TextView>(R.id.CB_DESC).setText(li)

        return localView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //val tv = view?.findViewById<TextView>(R.id.Desc_1)?.setText("lol" + parsedCivs.name)
    }

    fun GetCivInfo(){
        val xmlResourceParser: XmlResourceParser = resources.getXml(R.xml.civ_data)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }


    /*@JvmStatic
    fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/


    companion object {
        @JvmStatic
        fun newInstance(pc: ParsedCivs) =
                CivInfo().apply {
                    System.out.println("Placed Plaz")
                    arguments = Bundle().apply {
                        putParcelable("plaz",pc)
                    }
                }

    }
}
