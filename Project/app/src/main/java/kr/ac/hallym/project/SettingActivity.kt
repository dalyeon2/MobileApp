package kr.ac.hallym.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.project.databinding.ActivityAddBinding
import kr.ac.hallym.project.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_setting)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}