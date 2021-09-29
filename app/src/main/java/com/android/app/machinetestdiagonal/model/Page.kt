package com.android.app.machinetestdiagonal.model

data class Page(
    val content_items: ContentItems,
    val page_num: String,
    val page_size: String,
    val title: String,
    val total_content_items: String
)