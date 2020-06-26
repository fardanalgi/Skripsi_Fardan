package com.frdcompany.butikku.fragment.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Diskon (
    var katagori: String? ="",
    var title: String? ="",
    var harga: String? ="",
    var diskon: String? ="",
    var gambar: String? =""
): Parcelable