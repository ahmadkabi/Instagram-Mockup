package com.kodingan.instagrammockup.search

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationGridVertical(
    private val spanCount: Int,
    private val spacingPx: Int,
    private val includingEdge: Boolean,
) : RecyclerView.ItemDecoration() {

    var position = -1

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        position = parent.getChildAdapterPosition(view)
        val column = position % spanCount
        if (includingEdge) {
            outRect.left = spacingPx - column * spacingPx / spanCount
            outRect.right = (column + 1) * spacingPx / spanCount
            if (position < spanCount) {
                outRect.top = spacingPx
            }
            outRect.bottom = spacingPx

        } else {
            outRect.left = column * spacingPx / spanCount
            outRect.right = spacingPx - (column + 1) * spacingPx / spanCount
            if (position >= spanCount) {
                outRect.top = spacingPx
            }

        }

    }

}