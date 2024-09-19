package com.bignerdranch.nyethack.extensions
fun <T> Iterable<T>.randomizer(): T = this.shuffled().first()