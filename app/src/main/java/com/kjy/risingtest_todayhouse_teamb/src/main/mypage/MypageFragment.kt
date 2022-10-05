package com.kjy.risingtest_todayhouse_teamb.src.main.mypage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kakao.sdk.user.UserApiClient
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentHomeBinding
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentMypageBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.LoginActivity


class MypageFragment : BaseFragment<FragmentMypageBinding>(FragmentMypageBinding::bind, R.layout.fragment_mypage) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKakaoLogout.setOnClickListener {
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    showCustomToast("회원 탈퇴 실패")
                } else {
                    showCustomToast("회원 탈퇴 성공")
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        // 사진과 닉네임 정보 받아오기
        UserApiClient.instance.me { user, error ->
            binding.mypageNickname.text = "${user?.kakaoAccount?.profile?.nickname}"
            Glide.with(this)
                .load(user?.kakaoAccount?.profile?.thumbnailImageUrl)
                .into(binding.mypageIvProfile)
        }
    }
}