package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityPayBinding

class PayActivity : BaseActivity<ActivityPayBinding>(ActivityPayBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 메인 스피너에 입력할 가상의 데이터 작성
        var mainSpinnerData = listOf("배송시 요청사항을 선택해주세요", "부재시 문앞에 놓아주세요", "배송전에 미리 연락주세요", "부재시 경비실에 맡겨주세요", "부재시 전화주시거나 문자 남겨주세요", "직접입력")
        var shippingAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainSpinnerData)
        binding.paySpinShipping.adapter = shippingAdapter


        // 주문자 레이아웃에서 이메일 도메인 선택 스피너
        var emailSpinnerData = listOf("선택해주세요", "naver.com", "hanmail.net", "daum.net", "gmail.com", "kakao.com",
                                        "nate.com", "hotmail.com", "outlook.com", "icloud.com", "직접 입력")
        var emailAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emailSpinnerData)
        binding.paySpinEmailSelect.adapter = emailAdapter

        // 주문자 레이아웃에서 휴대폰 선택 스피너
        var phoneSpinnerData = listOf("선택해주세요","010", "011", "016", "017", "018", "019")
        var phoneAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phoneSpinnerData)
        binding.paySpinPhoneSelect.adapter = phoneAdapter



        // 주문자 레이아웃 버튼 클릭시
        binding.payBtnExpandedBuyerLayout.setOnClickListener {
        if(binding.payLayoutBuyerDetail.visibility == View.VISIBLE) {
            binding.payLayoutBuyerDetail.visibility = View.GONE
            binding.payLayoutBuyerLayoutTitle.visibility = View.VISIBLE
            binding.payBtnExpandedBuyerLayout.animate().apply {
                duration = 300
                rotation(0f)
            }
        }else {
            binding.payLayoutBuyerDetail.visibility = View.VISIBLE
            binding.payLayoutBuyerLayoutTitle.visibility = View.GONE
            binding.payBtnExpandedBuyerLayout.animate().apply {
                duration = 300
                rotation(180f)
            }
        }
        }
    }

}