package com.avila.apps.courses.mdc

import android.graphics.drawable.Drawable
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.avila.apps.courses.mdc.databinding.ActivityScrollingBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.bottomappbar.BottomAppBar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode ==
                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }
        */

        binding.fab.setOnClickListener {
            if (binding.bottomAppBar.fabAlignmentMode ==
                BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }

        binding.bottomAppBar.setOnClickListener {
            Snackbar.make(binding.root, R.string.black_friday, Snackbar.LENGTH_LONG).setAnchorView(binding.fab).show()
        }

        binding.content.btnSkip.setOnClickListener {
            binding.content.cvAd.visibility = View.GONE
        }


        binding.content.btnBuy.setOnClickListener {
            Snackbar.make(it, R.string.black_friday, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .setAction(R.string.card_btn_buy, {
                    Toast.makeText(this, R.string.black_friday, Toast.LENGTH_SHORT).show()
                })
                .show()
        }

        Glide.with(this)
            .load("https://www.creaxid.com.mx/blog/wp-content/uploads/2017/04/OS_Mobiles.jpg")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgCover)

        binding.content.chkEnablePass.setOnClickListener {
            binding.content.tilPassword.isEnabled = !binding.content.tilPassword.isEnabled
        }

        binding.content.etUrl.onFocusChangeListener = View.OnFocusChangeListener { view, focused ->
            val url = binding.content.etUrl.text.toString()
            if (!focused){
                binding.content.imgCover.loadUrl(url)

                /*
                Glide.with(this)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .centerCrop()
                    .into(binding.content.imgCover)
                */

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}