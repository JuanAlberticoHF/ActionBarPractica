package com.example.actionbarpractica

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tbCard: Toolbar
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbarPrincipal))

        supportActionBar?.setDisplayShowTitleEnabled(false)

        tbCard = findViewById(R.id.tbCard)
        tbCard.title = "tarjeta con menú"
        tbCard.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_borrar -> {
                    Log.i("ActionBar", "Acción borrar")
                    true
                }
                else -> {
                    true
                }
            }
        }
        tbCard.inflateMenu(R.menu.menu_tarjeta)

        // ViewPager
        viewPager=findViewById(R.id.viewpager)
        val adapta=ViewPagerAdaptador(this, 6)
        viewPager.adapter = adapta

        viewPager.orientation=ViewPager2.ORIENTATION_VERTICAL

        // Tab Layout
        tabLayout=findViewById(R.id.appbartabs)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Primera"
                }
                1 -> {
                    tab.text = "Segunda"
                }
                2 -> {
                    tab.text = "Tercera"
                }
                3 -> {
                    tab.text = "Cuarta"
                }
                4 -> {
                    tab.text = "Quinta"
                }
                5 -> {
                    tab.text = "Sexta"
                }
            }
        }.attach()

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_file -> {
            Log.i("ActionBar", "Archivo!")
            true
        }
        R.id.action_buscar -> {
            Log.i("ActionBar", "Buscar!")
            true
        }
        R.id.action_opciones -> {
            Log.i("ActionBar", "Opciones!")
            true
        }
        R.id.action_salir -> {
            Log.i("ActionBar", "Salir!")
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}