package com.blendworks.tony.aoe2_helper

import android.os.Parcel
import android.os.Parcelable


class ParsedCivs() : Parcelable {
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var id: Int = 0
    var name: String? = null
    var UU: String? = null
    var TeamBonus: String? = null
    var CivBonus: String? = null
    var Focus: String? = null
    var CUT: String? = null
    var IUT: String? = null
    var Missing: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()
        UU = parcel.readString()
        TeamBonus = parcel.readString()
        CivBonus = parcel.readString()
        Focus = parcel.readString()
        CUT = parcel.readString()
        IUT = parcel.readString()
        Missing = parcel.readString()
    }

    override fun toString(): String {
        return id.toString() +": "+ name;
    }

    companion object CREATOR : Parcelable.Creator<ParsedCivs> {
        override fun createFromParcel(parcel: Parcel): ParsedCivs {
            return ParsedCivs(parcel)
        }

        override fun newArray(size: Int): Array<ParsedCivs?> {
            return arrayOfNulls(size)
        }
    }
}