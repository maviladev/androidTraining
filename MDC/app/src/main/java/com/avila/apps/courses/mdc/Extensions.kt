package com.avila.apps.courses.mdc

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadUrl(
    url: String = "https://picsum.photos/200/300.jpg",
    cache: DiskCacheStrategy = DiskCacheStrategy.RESOURCE
) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .diskCacheStrategy(cache)
        .into(this)
}