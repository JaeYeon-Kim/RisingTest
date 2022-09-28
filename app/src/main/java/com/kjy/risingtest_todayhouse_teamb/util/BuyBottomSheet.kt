package com.kjy.risingtest_todayhouse_teamb.util

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.BuyBottomSheetBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.PayActivity

// 상품 구매 액티비티에서 구매하기 클릭시 나오는 바텀시트 다이얼로그 프래그먼트
class BuyBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: BuyBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = BuyBottomSheetBinding.inflate(inflater ,container, false)
        return binding.root
    }

    companion object {
        const val TAG = "BuyBottomSheet"
    }

    // 이벤트 처리는 onViewCreated 안에서
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 메인 스피너에 입력할 가상의 데이터 작성
        var mainSpinnerData = listOf("색상", "베이지")
        var mainAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, mainSpinnerData)
        binding.bottomSpinMain.adapter = mainAdapter

        // 서브 스피너에 입력할 가상의 데이터 작성
        var subSpinnerData = listOf("사이즈", "Small", "Medium", "Large")
        var subAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, subSpinnerData)
        binding.bottomSpinSub.adapter = subAdapter

        binding.dialogBtnDismiss.setOnClickListener {
            dialog?.dismiss()
        }

        // 바로 구매 클릭시 결제 액티비티로 이동
        binding.sheetBtnQuickBuy.setOnClickListener {
            val intent = Intent(requireContext(), PayActivity::class.java)
            startActivity(intent)
            dialog?.dismiss()
        }

    }

}