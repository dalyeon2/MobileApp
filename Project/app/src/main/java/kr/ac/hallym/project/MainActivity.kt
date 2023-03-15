package kr.ac.hallym.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.project.databinding.ActivityEditBinding
import kr.ac.hallym.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var contents: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 탭바
        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            when(position) {
                0 -> tab.text = "My Profile"
                1 -> tab.text = "List"
                2 -> tab.text = "Detail"
            }
        }.attach()

        //ActionBarDrawerToggle 버튼 적용
        val toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened,
            R.string.drawer_closed)
        toggle.syncState()

        // 네비게이션 바
        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log .d("kkang", "navigation item is clicked: ${it.title}")
            true
        }

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            it.data!!.getStringExtra("result")?.let {
                contents?.add(it)
                adapter.notifyDataSetChanged()
            }
        }
        binding.mainFab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        contents = savedInstanceState?.let {
            it.getStringArrayList("contents")?.toMutableList()
        } ?: let {
            mutableListOf<String>()
        }

        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select * from TODO_TB", null)
        cursor.run {
            while (moveToNext()) {
                contents?.add(cursor.getString(1))
            }
        }
        db.close()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("contents", ArrayList(contents))
    }

    // 옵션 메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.title) {
            "logout" -> {
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        if (item.itemId == R.id.menu_main_setting) {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}

class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}