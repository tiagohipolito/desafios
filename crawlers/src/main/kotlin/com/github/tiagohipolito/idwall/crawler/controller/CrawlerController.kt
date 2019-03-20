package com.github.tiagohipolito.idwall.crawler.controller

import com.github.tiagohipolito.idwall.crawler.service.RedditCrawlerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CrawlerController(val redditCrawlerService: RedditCrawlerService) {

    /*@ResponseStatus(HttpStatus.OK)
    @GetMapping("/upvotes")
    fun getAll() = redditCrawlerService.get*/

}

