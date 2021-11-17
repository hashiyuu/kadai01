package com.example.kadai01

import android.os.Bundle
import android.view.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.kadai01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       // AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController)

    }
}

//        binding.button01.setOnClickListerner { view ->
//            naviController.navigate(R.id.action_to_kadaiEditFragment)
//        }


//
//    override fun onSupportNavigateUp() =
//        findNavController(R.id.nav_host_fragment_container).navigateUp()
//
//
//    fun setButton01Visible(visibility: Int) {
//        binding..visibility = visibility
//    }
//}