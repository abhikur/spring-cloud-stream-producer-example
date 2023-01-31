package com.abhikur.springcloudstreamproducer.controller

import com.abhikur.springcloudstreamproducer.domain.Todo
import com.abhikur.springcloudstreamproducer.messaging.producer.MessageProducer
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class TodoController(
    val streamBridge: StreamBridge
) {

    @PostMapping("/")
    fun createTodo(@RequestBody todoItem: Todo): ResponseEntity<Todo> {
        val messageProducer = MessageProducer()
        messageProducer.publishStringMessage(streamBridge, todoItem)
        return ResponseEntity(todoItem, HttpStatus.CREATED)
    }
}
