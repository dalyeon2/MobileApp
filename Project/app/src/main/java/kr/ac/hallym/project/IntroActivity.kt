package kr.ac.hallym.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        findViewById<Button>(R.id.Enter).setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}