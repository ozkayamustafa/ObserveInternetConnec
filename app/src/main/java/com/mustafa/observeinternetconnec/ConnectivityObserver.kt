package com.mustafa.observeinternetconnec

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow

interface ConnectivityObserver {
    fun observe():Flow<Status>

    enum class Status{
        Available,Unavailable,Losing,Lost
    }
}