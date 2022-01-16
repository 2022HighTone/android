package com.iamgonna.android.setSchool.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iamgonna.android.databinding.ActivitySetSchoolBinding
import com.iamgonna.android.setSchool.viewModel.SetSchoolViewModel

class SetSchoolActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySetSchoolBinding.inflate(layoutInflater) }
    private val viewModel = SetSchoolViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
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
            ivSearchSchool.setOnClickListener {
                if (etSearchSchool.text!!.isNotBlank()){
                    viewModel.searchSchool(etSearchSchool.text.toString())
                }
            }

        }
        viewModel.schoolData.observe(this,{
            binding.etSearchSchool.setText(it)
        })
    }
}