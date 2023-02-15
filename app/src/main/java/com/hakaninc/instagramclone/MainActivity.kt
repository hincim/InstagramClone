package com.hakaninc.instagramclone

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hakaninc.instagramclone.databinding.ActivityMainBinding
import com.hakaninc.instagramclone.fragments.HomeFragment
import com.hakaninc.instagramclone.fragments.NotificationsFragment
import com.hakaninc.instagramclone.fragments.ProfileFragment
import com.hakaninc.instagramclone.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    internal var selectedFragment : Fragment ?= null


    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {

                    selectedFragment = HomeFragment()
                }
                R.id.nav_search -> {
                    selectedFragment = SearchFragment()
                }
                R.id.nav_add_post -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_notifications -> {
                    selectedFragment = NotificationsFragment()
                }
                R.id.nav_profile -> {
                    selectedFragment = ProfileFragment()
                }
            }

            if (selectedFragment != null){
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    selectedFragment!!
                ).commit()
            }

            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            HomeFragment()
        ).commit()

    }
}