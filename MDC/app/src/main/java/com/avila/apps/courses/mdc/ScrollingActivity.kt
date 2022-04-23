package com.avila.apps.courses.mdc

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