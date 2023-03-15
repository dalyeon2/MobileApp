package kr.ac.hallym.project

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.project.databinding.FragmentOneBinding
import kr.ac.hallym.project.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_one, container, false)
        val binding = FragmentTwoBinding.inflate(inflater, container, false)

        //리사이클러 뷰를 위한 데이터 준비
        val contents = mutableListOf<String>("3D 이미지 작업", "웹페이지 복구", "사이트 웹디자인", "캐릭터 디자인")
        val contents_sub = mutableListOf<String>("이미지에 대한 작업물", "웹페이지를 복구", "웹디자인", "2D 캐릭터 디자인")
        val contents_date = mutableListOf<String>("2022년 1월", "2022 4월", "2022 9월", "2022 10월")
        
        //리사이클러 뷰에 LayoutManger, Adapter, ItemDecoration 적용
        val adapter = MyAdapter(contents, contents_sub, contents_date)
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))

        return binding.root

    }
}