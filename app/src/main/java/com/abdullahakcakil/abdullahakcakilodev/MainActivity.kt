package com.abdullahakcakil.abdullahakcakilodev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.abdullahakcakil.abdullahakcakilodev.ui.main.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.abdullahakcakil.abdullahakcakilodev.data.repository.MainRepository
import com.abdullahakcakil.abdullahakcakilodev.ui.pro.MainViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        navController = Navigation.findNavController(this, R.id.ac_ma_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        val mainRepository = MainRepository()
        val viewModelProviderFactory = MainViewModelProviderFactory(application, mainRepository)
        mainViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)

    }
    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.ac_ma_nav_host_fragment).navigateUp() || super.onSupportNavigateUp()
    }

    fun showLoading(){
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        ac_main_pb.visibility = View.VISIBLE
    }

    fun hideLoading(){
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        ac_main_pb.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hakkinda,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.hakkinda -> startActivity(Intent(this, HakkimdaActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

}

