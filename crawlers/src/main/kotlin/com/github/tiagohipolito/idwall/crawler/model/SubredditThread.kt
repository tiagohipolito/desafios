package com.github.tiagohipolito.idwall.crawler.model

data class SubredditThread(val subreddit : String,
                           val upvotes : Int,
                           val title: String,
                           val commentsUrl:String,
                           val link: String)