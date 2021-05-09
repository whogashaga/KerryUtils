package com.kerry.utilslibrary.viewbinding.internal

import android.app.Activity
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.annotation.RestrictTo
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@RestrictTo(RestrictTo.Scope.LIBRARY)
@PublishedApi
internal fun <V : View> Activity.requireViewByIdCompat(@IdRes viewId: Int): V {
    return ActivityCompat.requireViewById(this, viewId)
}

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