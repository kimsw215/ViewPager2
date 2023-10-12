package com.example.viewpager2

import ViewPagerDiffUtilAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2.Class.ZoomOutPageTransformer
import com.example.viewpager2.DataVo.AimyonData
import com.example.viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding?= null
    private val binding get() = _binding!!

    private lateinit var adapter: ViewPagerDiffUtilAdapter

    private val dataList = mutableListOf<AimyonData>(
        AimyonData(R.drawable.blue,"블루묭"),
        AimyonData(R.drawable.banana,"바나나묭"),
        AimyonData(R.drawable.banana,"바나나묭"),
        AimyonData(R.drawable.banana,"바나나묭"),
        AimyonData(R.drawable.banana,"바나나묭"),
        AimyonData(R.drawable.banana,"바나나묭"),
        AimyonData(R.drawable.banana,"바나나묭"),
        AimyonData(R.drawable.onigiri,"오니기리묭")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ViewPagerDiffUtilAdapter()

        binding.run {
            viewpager.adapter = adapter
            viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            viewpager.setPageTransformer(ZoomOutPageTransformer())

            // ViewPager2의 현재 페이지 변화 감지
            viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
/*
                    // 현재 페이지가 마지막 페이지일 때, 다음에 나올 페이지로 이동
                    if (position == adapter.itemCount - 1) {
                        viewpager.setCurrentItem(1, false)
                    }

                    // 현재 페이지가 첫 페이지일 때, 이전에 나왔던 마지막 페이지로 이동
                    if (position == 0) {
                        viewpager.setCurrentItem(adapter.itemCount - 2, false)
                    }*/
                }
            })

            springDotsIndicator.setViewPager2(viewpager)
        }

        // 실제 데이터를 어댑터에 제출
        adapter.submitList(dataList)
    }
    

}