package com.maciejkozlowski.viewmanagersample

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.maciejkozlowski.viewmanagersample.first.FirstFragment
import com.maciejkozlowski.viewmanagersample.second.SecondFragment
import com.maciejkozlowski.viewmanagersample.third.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationBottom.setNavigationItemSelectedListener(this::onItemSelected)
        showFragment(ThirdFragment.newInstance())
    }

    private fun onItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.firstTabItem -> showFragment(FirstFragment.newInstance())
            R.id.secondTabItem -> showFragment(SecondFragment.newInstance())
            else -> showFragment(ThirdFragment.newInstance())
        }

        return true
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
