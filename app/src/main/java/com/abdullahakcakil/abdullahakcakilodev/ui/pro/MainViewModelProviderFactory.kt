package com.abdullahakcakil.abdullahakcakilodev.ui.pro

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdullahakcakil.abdullahakcakilodev.data.repository.MainRepository
import com.abdullahakcakil.abdullahakcakilodev.ui.main.MainViewModel

class MainViewModelProviderFactory(val app: Application,
                                   private val mainRepository: MainRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app, mainRepository) as T
    }
}