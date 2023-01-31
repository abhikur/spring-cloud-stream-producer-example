package com.abhikur.springcloudstreamproducer.domain

data class Todo(
    val title: String
) {
    override fun toString(): String {
        return "Todo(title='$title')"
    }
}
