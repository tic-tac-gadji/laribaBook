package com.example.mycyberchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.mycyberchallenge.ui.books.CategoryFragment
import com.example.mycyberchallenge.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val navController = findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )


        var  navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val fragmentHome: Fragment = HomeFragment()
        val fm: FragmentManager = supportFragmentManager
        var active: Fragment = fragmentHome

//        fm.beginTransaction().add(R.id.nav_host_fragment, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().replace(R.id.nav_host_fragment, fragmentHome, "1").commit()

        val navBarListener = BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_dashboard -> {
                    navController.navigate(R.id.navigation_dashboard)
//                    val fragment = CategoryFragment()
//                    fm.beginTransaction().replace(R.id.nav_host_fragment, fragment, "2").commit()
//                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_home -> {
                    navController.navigate(R.id.navigation_home)
//                    val fragment = HomeFragment()
//                    fm.beginTransaction().replace(R.id.nav_host_fragment, fragment, "3").commit()
//                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_basket -> {
                    navController.navigate(R.id.navigation_basket)

                }
            }

            false
        }

        nav_view.setOnNavigationItemSelectedListener(navBarListener)
    }
}
