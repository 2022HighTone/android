package com.iamgonna.android.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iamgonna.android.R
import com.iamgonna.android.databinding.ActivityMainBinding
import com.iamgonna.android.main.viewModel.MainViewModel
import com.iamgonna.android.storeDetail.StoreDetailActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.Overlay
import com.naver.maps.map.overlay.OverlayImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel = MainViewModel()
    private lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getDefaultLocation()
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        binding.ivSearchSchool.setOnClickListener {
            viewModel.findSchool(binding.etSearchSchool.text.toString())
        }
        binding.bottomSheetLayout.apply {
            tvCafe.setOnClickListener {
                tvCafe.isSelected = !tvCafe.isSelected
            }
            tvChinese.setOnClickListener {
                tvChinese.isSelected = !tvChinese.isSelected
            }
            tvHamburger.setOnClickListener {
                tvHamburger.isSelected = !tvHamburger.isSelected
            }
            tvJapanese.setOnClickListener {
                tvJapanese.isSelected = !tvJapanese.isSelected
            }
            tvKorean.setOnClickListener {
                tvKorean.isSelected = !tvKorean.isSelected
            }
            tvSnack.setOnClickListener {
                tvSnack.isSelected = !tvSnack.isSelected
            }
            layAllChoice.setOnClickListener {
                ivCheck.isSelected = !ivCheck.isSelected
                tvSnack.isSelected = ivCheck.isSelected
                tvKorean.isSelected = ivCheck.isSelected
                tvJapanese.isSelected = ivCheck.isSelected
                tvHamburger.isSelected = ivCheck.isSelected
                tvChinese.isSelected = ivCheck.isSelected
                tvCafe.isSelected = ivCheck.isSelected
            }
            rangeSlider.addOnChangeListener { slider, _, _ ->
                tvPay.text = "${slider.values[0].toInt()}원 ~ ${slider.values[1].toInt()}원"
            }
        }
    }

    override fun onMapReady(naverMap: NaverMap) {
        val marker = Marker()
        viewModel.defaultLocation.observe(this,{
            val cameraUpdate = CameraUpdate.scrollTo(it)
            naverMap.moveCamera(cameraUpdate)
        })
        viewModel.storeLocation.observe(this,{

            marker.position = LatLng(it.latitude,it.longitude)
            when(it.category_name){
                "SNACK" -> {marker.icon = OverlayImage.fromResource(R.drawable.ic_snack_marker)}
                "KOREAN" ->{marker.icon = OverlayImage.fromResource(R.drawable.ic_korean_marker)}
                "FASTFOOD"->{marker.icon = OverlayImage.fromResource(R.drawable.ic_fast_food_marker)}
                "CHINESE"->{marker.icon = OverlayImage.fromResource(R.drawable.ic_chinese_marker)}
                "JAPANESE"->{marker.icon = OverlayImage.fromResource(R.drawable.ic_japanese_marker)}
                "CAFE"->{marker.icon = OverlayImage.fromResource(R.drawable.ic_cafe_marker)}
            }
            marker.map = naverMap
        })
        marker.onClickListener = Overlay.OnClickListener {
            val intent = Intent(applicationContext, StoreDetailActivity::class.java)
            startActivity(intent)
            false
        }
    }
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

}