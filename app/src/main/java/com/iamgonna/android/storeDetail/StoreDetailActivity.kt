package com.iamgonna.android.storeDetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.iamgonna.android.databinding.ActivityStoreDetailBinding

class StoreDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityStoreDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.layTab.addTab(binding.layTab.newTab().setText("메뉴"))
        binding.layTab.addTab(binding.layTab.newTab().setText("리뷰"))

    }
}