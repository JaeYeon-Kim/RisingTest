package com.kjy.risingtest_todayhouse_teamb.src.main.store


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentStoreBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.CategoryData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.StoreCategoryAdapter


class StoreFragment : BaseFragment<FragmentStoreBinding>(FragmentStoreBinding::bind, R.layout.fragment_store){

    private var categoryList = mutableListOf<CategoryData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        // 스와이프 리프레시 레이아웃 기능 넣기
        // false로 해주어야 새로고침 아이콘이 사라짐
        binding.storeLayoutRefresh.setOnRefreshListener {
            binding.storeLayoutRefresh.isRefreshing = false
        }

        binding.storeSv.viewTreeObserver.addOnScrollChangedListener {
            binding.storeLayoutRefresh.isEnabled = (binding.storeSv.scrollY == 0)
        }

        // 스토어 프래그먼트 메인 카테고리 리사이클러뷰
        categoryRecycler()
    }

    override fun onStop() {
        super.onStop()
        binding.storeSv.viewTreeObserver.removeOnScrollChangedListener{

        }
    }

    // 스토어 프래그먼트의 메인 카테고리 리사이클러뷰 구현
    private fun categoryRecycler() {
        var adapter = StoreCategoryAdapter()
        binding.storeRvCategory.adapter = adapter
        categoryList.apply {
            add(CategoryData(R.drawable.store_category_kitchen, "주방필템"))
            add(CategoryData(R.drawable.store_category_best, "베스트"))
            add(CategoryData(R.drawable.store_category_today, "오늘의딜"))
            add(CategoryData(R.drawable.store_category_goods, "오!굿즈"))
            add(CategoryData(R.drawable.store_category_quick, "빠른배송"))
            add(CategoryData(R.drawable.store_category_premium, "프리미엄"))
            add(CategoryData(R.drawable.store_category_rippermarket, "리퍼마켓"))
            add(CategoryData(R.drawable.store_category_new, "신상특가"))
            add(CategoryData(R.drawable.store_category_foodmarket, "푸드마켓"))
            add(CategoryData(R.drawable.store_category_special, "기획전"))
        }
        adapter.categoryList = categoryList
        val layoutManager = GridLayoutManager(requireContext(), 5)
        binding.storeRvCategory.layoutManager = layoutManager
        adapter.notifyDataSetChanged()

    }

}