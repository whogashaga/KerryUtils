package com.kerry.kerryutils

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified VM : ViewModel> Fragment.viewModelsFactory(
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