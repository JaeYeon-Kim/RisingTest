package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change

import android.content.Intent
import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityReturnChangeBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.model.ResultReturn
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.model.ReturnResponse

class ReturnChangeActivity : BaseActivity<ActivityReturnChangeBinding>(ActivityReturnChangeBinding::inflate), ReturnActivityInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 판매자 정보 API 호출
        ReturnService(this).tryGetReturn()

        binding.returnBtnBack.setOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


    // 판매자 정보를 받아옴
    override fun onGetReturnSuccess(response: ReturnResponse) {
            binding.returnTvStoreAddress.text = response.result.storeAddress
            binding.returnTvStoreAddress2.text = response.result.storeAddress
            binding.returnTvStoreName.text = response.result.storeName
            binding.returnTvStorePhoneNumber.text = response.result.storePhoneNumber
            binding.returnTvSellerName.text = response.result.storeSeller
            binding.returnTvCompanyNumber.text = response.result.companyNumber
            binding.returnTvEmail.text = response.result.email

    }

    override fun onGetFailure(message: String) {
        Log.e("배송/교환/환불 액티비티", "$message")
    }
}