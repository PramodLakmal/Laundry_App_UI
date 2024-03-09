package com.project.laundryappui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.project.laundryappui.menu.home.HomeFragment
import com.project.laundryappui.menu.message.MessageFragment
import com.project.laundryappui.menu.notification.NotificationFragment
import com.project.laundryappui.menu.search.SearchFragment
import java.util.Objects

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        initViews()
        initComponentsNavHeader()
        loadFragment(HomeFragment())
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setTitle(0)
    }

    private fun initViews() {
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(this)
        /**
         * Menu Navigation Drawer
         */
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = false
        toggle.toolbarNavigationClickListener =
            View.OnClickListener { view: View? -> drawer.openDrawer(GravityCompat.START) }
        toggle.setHomeAsUpIndicator(R.drawable.ic_drawer)
        toggle.syncState()
    }
    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.nav_menu_home -> fragment = HomeFragment()
            R.id.nav_menu_search -> fragment = SearchFragment()
            R.id.nav_menu_notification -> fragment = NotificationFragment()
            R.id.nav_menu_message -> fragment = MessageFragment()
        }
        return loadFragment(fragment)
    }

    private fun initComponentsNavHeader() {
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        //        navigationView.setItemIconTintList(null); //disable tint on each icon to use color icon svg
        navigationView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nav_my_account -> navigateTo("My Account")
                    R.id.nav_support -> navigateTo("Support")
                    R.id.nav_setting -> navigateTo("Setting")
                    R.id.nav_help -> navigateTo("Help")
                }
                val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
                drawer.closeDrawer(GravityCompat.START)
                return true
            }

            private fun navigateTo(message: String) {
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_profile, menu)
        return true
    }

}