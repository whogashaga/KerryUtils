package com.kerry.utilslibrary;

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.kerry.utilslibrary.application.ApplicationProvider

fun Activity?.getStringRes(@StringRes id: Int): String {
    if (this == null) {
        return ApplicationProvider.getInstance().getProviderAppResources().getString(id)
    }
    return this.resources.getString(id)
}

fun Fragment?.getStringRes(@StringRes id: Int): String {
    if (this?.context == null) {
        return ApplicationProvider.getInstance().getProviderAppResources().getString(id)
    }
    return this.resources.getString(id)
}

fun View?.getStringRes(@StringRes id: Int): String {
    if (this?.context == null) {
        return ApplicationProvider.getInstance().getProviderAppResources().getString(id)
    }
    return this.resources.getString(id)
}

fun Activity?.getStringRes(@StringRes id: Int, vararg formatArgs: Any?): String {
    if (this == null) {
        return ApplicationProvider.getInstance().getProviderAppResources()
            .getString(id, *formatArgs)
    }
    return this.resources.getString(id, *formatArgs)
}

fun Fragment?.getStringRes(@StringRes id: Int, vararg formatArgs: Any?): String {
    if (this?.context == null) {
        return ApplicationProvider.getInstance().getProviderAppResources()
            .getString(id, *formatArgs)
    }
    return this.resources.getString(id, *formatArgs)
}

fun View?.getStringRes(@StringRes id: Int, vararg formatArgs: Any?): String {
    if (this?.context == null) {
        return ApplicationProvider.getInstance().getProviderAppResources()
            .getString(id, *formatArgs)
    }
    return this.resources.getString(id, *formatArgs)
}

fun Activity?.getColorRes(@ColorRes id: Int): Int {

    if (this == null) {
        return ContextCompat.getColor(ApplicationProvider.getInstance().getProviderAppContext(), id)
    }
    return ContextCompat.getColor(this, id)
}

fun Fragment?.getColorRes(@ColorRes id: Int): Int {

    val context = this?.context ?: ApplicationProvider.getInstance().getProviderAppContext()

    return ContextCompat.getColor(context, id)
}

fun View?.getColorRes(@ColorRes id: Int): Int {

    val context = this?.context ?: ApplicationProvider.getInstance().getProviderAppContext()

    return ContextCompat.getColor(context, id)
}

fun Activity?.getDrawableRes(@DrawableRes id: Int): Drawable? {

    if (this == null) {
        return ContextCompat.getDrawable(
            ApplicationProvider.getInstance().getProviderAppContext(),
            id
        )
    }

    return ContextCompat.getDrawable(this, id)
}

fun Fragment?.getDrawableRes(@DrawableRes id: Int): Drawable? {

    val context = this?.context ?: ApplicationProvider.getInstance().getProviderAppContext()

    return ContextCompat.getDrawable(context, id)
}

fun View?.getDrawableRes(@DrawableRes id: Int): Drawable? {

    val context = this?.context ?: ApplicationProvider.getInstance().getProviderAppContext()

    return ContextCompat.getDrawable(context, id)
}