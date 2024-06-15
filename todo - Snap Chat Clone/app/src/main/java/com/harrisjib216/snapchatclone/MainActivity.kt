/*
learning resources
https://www.youtube.com/watch?v=BCSlZIUj18Y

https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012
https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012
https://www.udacity.com/course/android-kotlin-developer-nanodegree--nd940

free articles
https://antonioleiva.com/free-kotlin-android-course/

algo
https://www.udacity.com/course/android-kotlin-developer-nanodegree--nd940


chat
https://www.youtube.com/watch?v=ihJGxFu2u9Q&list=PL0dzCUj1L5JE-jiBHjxlmXEkQkum_M3R-

insta
https://www.youtube.com/watch?v=9CjxFd3LgLE&list=PLFzlb57tNKUOrFIcicZ88qmaeHTA_9t_6


 */

package com.harrisjib216.snapchatclone

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager2? = null
    private val CAMERA_PERMISSIONS = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.RECORD_AUDIO
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // check perms
        // todo: toggle loading
        checkPermission()

        // set up tabs
        setUpTabs()
    }

    // todo: make async
    private fun checkPermission() {
        if (
            !CAMERA_PERMISSIONS.all {
                ContextCompat.checkSelfPermission(
                    applicationContext,
                    it
                ) == PackageManager.PERMISSION_GRANTED
            }
        ) {
            ActivityCompat.requestPermissions(this, CAMERA_PERMISSIONS, 0)
        }
    }

    private fun setUpTabs() {
        viewPager = findViewById(R.id.viewPager)
        viewPager?.adapter = SlidingPagerAdapter(this)

         viewPager?.let {
             val screens = arrayOf(
                 mapOf(
                     "screen" to "Messages",
                     "icon" to "",
                 ),
                 mapOf(
                     "screen" to "Camera",
                     "icon" to "",
                 ),
                 mapOf(
                     "screen" to "Feed",
                     "icon" to "",
                 ),
             )

            val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
            TabLayoutMediator(tabLayout, viewPager as ViewPager2) { tab, index ->
                tab.text = screens[index]["screen"]
            }.attach()
        } ?: run {
            throw Exception("view pager was not set")
        }
    }
}
