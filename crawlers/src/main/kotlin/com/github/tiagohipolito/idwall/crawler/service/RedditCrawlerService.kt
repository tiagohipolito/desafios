package com.github.tiagohipolito.idwall.crawler.service

import com.github.tiagohipolito.idwall.crawler.model.SubredditThread
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RedditCrawlerService {

    @Value("\${app.reddit.url}")
    lateinit var redditUrl: String

    fun retrieveInfo(subreddits: String) = subreddits.split(";").flatMap { retrieveSubredditInfo(it) }

    private fun retrieveSubredditInfo(subredditName: String): List<SubredditThread> {
        val doc = Jsoup.connect("$redditUrl$subredditName/").ignoreHttpErrors(true).get()
        return doc.getElementsByClass("thing").filter {
            it.getElementsByClass("score unvoted").attr("title") != "" && it.getElementsByClass("score unvoted").attr("title").toInt() >= 5000
        }.map {
            var link = it.getElementsByClass("title").attr("href")
            if (link.isNotBlank() && !link.contains("http")) {
                link = redditUrl + link
            }
            SubredditThread(subreddit = subredditName,
                    upvotes = it.getElementsByClass("score unvoted").attr("title").toInt(),
                    title = it.select("a.title").text(),
                    link = link,
                    commentsUrl = it.getElementsByClass("comments").attr("href")
            )
        }
    }
}