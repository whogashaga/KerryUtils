package com.kerry.kerryutils.application

import android.content.Context
import android.content.res.Resources

interface IApplicationProvider {
    fun getProviderAppContext(): Context
    fun getProviderAppResources(): Resources
}