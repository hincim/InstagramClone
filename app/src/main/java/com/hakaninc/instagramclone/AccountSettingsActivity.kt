package com.hakaninc.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.hakaninc.instagramclone.databinding.ActivityAccountSettingsBinding

class AccountSettingsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAccountSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logoutBtn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            val intent = Intent(this@AccountSettingsActivity, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}