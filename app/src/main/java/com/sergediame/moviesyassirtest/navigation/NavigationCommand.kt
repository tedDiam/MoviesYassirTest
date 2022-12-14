package com.sergediame.moviesyassirtest.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavOptions

interface NavigationCommand {
    val destination: String
    val configuration: NavOptions
        get() = NavOptions.Builder().build()
    val arguments: List<NamedNavArgument>
}