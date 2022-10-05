package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model.InquiryResponse

interface InquiryActivityInterface {

    fun onGetInquirySuccess(response: InquiryResponse)

    fun onGetInquiryFailure(message: String)
}