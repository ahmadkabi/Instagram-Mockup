package com.kodingan.instagramclone.util

import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE

fun View.gone(){
    this.visibility = GONE
}

fun View.invisible(){
    this.visibility = INVISIBLE
}

fun View.visible(){
    this.visibility = VISIBLE
}