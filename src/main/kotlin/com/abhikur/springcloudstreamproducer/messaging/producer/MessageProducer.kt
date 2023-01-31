package com.abhikur.springcloudstreamproducer.messaging.producer
import com.abhikur.springcloudstreamproducer.domain.Todo
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.stereotype.Service

@Service
class MessageProducer {

    fun publishStringMessage(streamBridge: StreamBridge, todoItem: Todo) {
        streamBridge.send("publishStringMessage-out-0", todoItem.toString())
    }
}

