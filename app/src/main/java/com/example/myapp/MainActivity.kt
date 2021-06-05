package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.main.MainFragment

class MainActivity : AppCompatActivity() {

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        currentFragment = MainFragment.getInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout, currentFragment!!, "LOGIN_TAG")
            .commit();
    }

  /*  override fun onStart() {
        super.onStart()
        val manager: FragmentManager = fragmentManager!!
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.frameLayout, MainFragment as Fragment, "FRRRAAAAAAG")
        transaction.addToBackStack(null)
        transaction.commit()
    }*/
}