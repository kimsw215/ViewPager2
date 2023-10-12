package com.example.viewpager2.Class

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class ZoomOutPageTransformer : ViewPager2.PageTransformer {
    private val MIN_SCALE = 0.85f
    private val MIN_ALPHA = 0.5f

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageHeight = page.height

        when {
            position < -1 -> { // 페이지가 왼쪽으로 완전히 사라질 때 페이지의 투명도를 0으로 만든다
                page.alpha = 0f
            }

            position <= 1 -> { // 페이지가 화면에 보임
                // 페이지의 크기를 조절하는데 사용되는 스케일 팩터를 계산한다
                val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                val vertMargin = pageHeight * ( 1 - scaleFactor ) / 2
                val horzMargin = pageWidth * ( 1 - scaleFactor ) / 2

                // 이동 및 크기 조정
                if (position < 0) {
                    // 페이지가 왼쪽으로 이동하게 될 경우
                    page.translationX = horzMargin - vertMargin / 2
                } else {
                    // 페이지가 오른쪽으로 이동하게 될 경우
                    page.translationX = - horzMargin + vertMargin / 2
                }

                page.scaleX = scaleFactor
                page.scaleY = scaleFactor

                // 투명도를 조절한다
                // 페이지의 스케일에 따라 투명도가 변경되도록 계산된다
                page.alpha = MIN_ALPHA +
                        ( scaleFactor - MIN_SCALE ) /
                        ( 1 - MIN_SCALE ) * ( 1 - MIN_ALPHA )
            }

            else -> { // 페이지가 오른쪽으로 완전히 사라짐
                page.alpha = 0f
            }
        }
    }
}