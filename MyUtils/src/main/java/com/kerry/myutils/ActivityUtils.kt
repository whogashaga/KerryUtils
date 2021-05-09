package com.kerry.myutils

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified VM : ViewModel> ComponentActivity.viewModelsFactory(
    noinline create: () -> VM
): Lazy<VM> {
    return viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM {
                return create() as VM
            }
        }
    }
}