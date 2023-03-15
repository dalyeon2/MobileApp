package kr.ac.hallym.project

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.project.databinding.FragmentOneBinding
import kr.ac.hallym.project.databinding.FragmentTwoBinding
import kr.ac.hallym.project.databinding.ItemRecyclerviewBinding
import java.lang.Exception

class OneFragment : Fragment() {
    lateinit var adapter: MyAdapter
    lateinit var filePath: String
    var contents: MutableList<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentOneBinding.inflate(inflater, container, false)

        binding.editButton.setOnClickListener {
            val intent = Intent(context, EditActivity::class.java)
            startActivity(intent)
        }
        binding.galleryButton.setOnClickListener {
            val intent = Intent(context, ImageActivity::class.java)
            startActivity(intent)
        }

        return inflater.inflate(R.layout.fragment_one, container, false)
    }
}

    /*


        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            it.data!!.getStringExtra("result")?.let {
                contents?.add(it)
                adapter.notifyDataSetChanged()
            }
        }

        binding.editButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            requestLauncher.launch(intent)
        }

        // 갤러리 요청 런처
        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            try {
                // inSampleSize 비율 계산, 지정
                val calRatio = calculateInSampleSize(
                    it.data!!.data!!,
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize)
                )
                val option = BitmapFactory.Options()
                option.inSampleSize = calRatio

                // 이미지 로딩
                var inputStream = contentResolver.openInputStream(it.data!!.data!!)
                val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
                inputStream!!.close()
                inputStream!!.close()
                inputStream = null

                bitmap?.let {
                    binding.userImageView.setImageBitmap(bitmap)
                } ?: let {
                    Log.d("kkang", "bitmap null")
                }
            }catch (e: Exception) {
                Log.d("kkang", "bitmap null")
            }
        }


        binding.galleryButton.setOnClickListener {
            //갤러리 앱
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }


    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true // 옵션만 설정하고자 true로 지정
        try {
            var inputStream = contentResolver.openInputStream(fileUri)
            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream!!.close()
            inputStream = null
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1
        //inSampleSize 비율 계산
        if (height > reqHeight || width > reqWidth) {
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2
            while (halfHeight / inSampleSize >= reqHeight &&
                halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }


     */
     */
