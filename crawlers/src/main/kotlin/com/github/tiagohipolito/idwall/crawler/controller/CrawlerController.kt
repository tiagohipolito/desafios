package com.github.tiagohipolito.idwall.crawler.controller

import com.github.tiagohipolito.idwall.crawler.service.RedditCrawlerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CrawlerController(val redditCrawlerService: RedditCrawlerService) {

    @GetMapping("/subreddits/upvotted/{subreddits}")
    fun getAll(@PathVariable subreddits: String) = redditCrawlerService.retrieveInfo(subreddits).sortedByDescending { it.upvotes }

}

