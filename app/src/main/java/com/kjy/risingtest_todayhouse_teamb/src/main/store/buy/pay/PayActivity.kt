package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityPayBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model.PayMethodAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model.PayMethodData

class PayActivity : BaseActivity<ActivityPayBinding>(ActivityPayBinding::inflate) {

    private val payAdapter = PayMethodAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 결제 방법 리사이클러뷰
        payMethodRecycler()


        // 결제 방법 리사이클러뷰 리스너
        payAdapter.setItemClickListener(object: PayMethodAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                when(position) {
                    0  -> {
                        showCustomToast("첫번째 아이템 입니다.")
                        v.isSelected = v.isSelected != true
                    }
                    1 -> {
                        showCustomToast("두번째 아이템 입니다.")
                        v.isSelected = v.isSelected != true
                    }

                    2 -> {
                        showCustomToast("세번째 아이템 입니다.")
                        v.isSelected = v.isSelected != true
                    }
                    3 -> {
                        showCustomToast("네번째 아이템 입니다.")
                        v.isSelected = v.isSelected != true
                    }
                    4 -> {
                        showCustomToast("다섯번째 아이템 입니다.")
                        v.isSelected = v.isSelected != true
                    }
                    5 -> {
                        showCustomToast("여섯번째 아이템 입니다.")
                        v.isSelected = v.isSelected != true
                    }
                    6 -> {
                        showCustomToast("일곱번째 아이템 입니다.")
                        v.isSelected = v.isSelected != true
                    }
                }
            }

        })


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

    private fun payMethodRecycler() {
        var payMethodList = arrayListOf<PayMethodData>(
                            PayMethodData(R.drawable.pay_method_icon_1, "카드", ""),
                            PayMethodData(R.drawable.pay_method_icon_2, "무통장입금", ""),
                            PayMethodData(R.drawable.pay_method_icon_3, "카카오페이", "1만원 즉시할인"),
                            PayMethodData(R.drawable.pay_method_icon_4, "토스", "3000원 적립"),
                            PayMethodData(R.drawable.pay_method_icon_5, "네이버페이", "최대5000적립"),
                            PayMethodData(R.drawable.pay_method_icon_6, "페이코", "최대3%적립"),
                            PayMethodData(R.drawable.pay_method_icon_7, "핸드폰", ""))

        binding.payRvPayMethod.adapter = payAdapter
        payAdapter.payMethodList = payMethodList
        val layoutManager = GridLayoutManager(this, 4)
        binding.payRvPayMethod.layoutManager = layoutManager
    }
    }
