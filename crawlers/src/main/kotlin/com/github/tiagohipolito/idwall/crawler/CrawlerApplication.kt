package com.github.tiagohipolito.idwall.crawler

import com.github.tiagohipolito.idwall.crawler.service.RedditCrawlerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrawlerApplication : CommandLineRunner {

    @Autowired
    lateinit var redditCrawlerService: RedditCrawlerService

    override fun run(vararg args: String?) {
        val subreddits = "askreddit;worldnews;cats"

        redditCrawlerService.retrieveInfo(subreddits).sortedByDescending { it.upvotes }.forEach {
            println("(${it.subreddit}) ${it.title}")
            println("upvotes: ${it.upvotes}")
            println("link: ${it.link}")
            println("comments: ${it.commentsUrl}")
            println()
        }
    }

}


fun main(args: Array<String>) {
    runApplication<CrawlerApplication>(*args)
}
