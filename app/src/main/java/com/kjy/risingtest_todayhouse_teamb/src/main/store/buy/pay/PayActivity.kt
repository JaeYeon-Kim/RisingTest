package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityPayBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.complete.CompleteActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model.PayMethodAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model.PayMethodData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model.PayOrderAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model.PayOrderData

class PayActivity : BaseActivity<ActivityPayBinding>(ActivityPayBinding::inflate) {

    private val payAdapter = PayMethodAdapter()

    private val orderAdapter = PayOrderAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.payBtnComplete.setOnClickListener{
            val intent = Intent(this, CompleteActivity::class.java)
            startActivity(intent)
        }

        // 결제 방법 리사이클러뷰
        payMethodRecycler()

        payOrderRecycler()


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
        binding.payLayoutBuyer.setOnClickListener {
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


        // 주문상품 레이아웃 클릭시 하단 리사이클러뷰를 접히게함
        binding.payBtnOrderLayoutExpandable.setOnClickListener {
            if(binding.payRvOrderLayout.visibility == View.VISIBLE) {
                binding.payRvOrderLayout.visibility = View.GONE
                binding.orderTvHidden.visibility = View.VISIBLE
                binding.payBtnExpandedOrderLayout.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                binding.payRvOrderLayout.visibility = View.VISIBLE
                binding.orderTvHidden.visibility = View.GONE
                binding.payBtnExpandedOrderLayout.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

        // 쿠폰 레이아웃 애니메이션 주기
        binding.payBtnCouponLayoutExpandable.setOnClickListener {
            if(binding.payBtnCouponLayoutExpandableDetail.visibility == View.VISIBLE) {
                binding.payBtnCouponLayoutExpandableDetail.visibility = View.GONE
                binding.payBtnCouponLayout.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                binding.payBtnCouponLayoutExpandableDetail.visibility = View.VISIBLE
                binding.payBtnCouponLayout.animate().apply {
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

    private fun payOrderRecycler() {
        var payorderList = arrayListOf<PayOrderData>(
            PayOrderData("(주)레토지엠에스", "[오늘의딜]레토 접이식 바베큐 불멍 캠핑화로 대 LCP-FB01", "LCP-FB01")
        )
        binding.payRvOrderLayout.adapter = orderAdapter
        orderAdapter.payOrderList = payorderList
        val layoutManager = LinearLayoutManager(this)
        binding.payRvOrderLayout.layoutManager = layoutManager
    }
    }
