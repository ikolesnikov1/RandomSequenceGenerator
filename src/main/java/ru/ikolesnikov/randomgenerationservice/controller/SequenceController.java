package ru.ikolesnikov.randomgenerationservice.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.ikolesnikov.randomgenerationservice.object.Message;
import ru.ikolesnikov.randomgenerationservice.object.Sequence;
import ru.ikolesnikov.randomgenerationservice.service.GenerationService;

@Controller
public class SequenceController {
    private final GenerationService service;

    public SequenceController(GenerationService service) {
        this.service = service;
    }

    @MessageMapping("/arr")
    @SendTo("/topic/main-array")
    public Sequence showMainArray(Message message) throws InterruptedException {
        return service.showMainArray(message);
    }

    @MessageMapping("/arr-sec")
    @SendTo("/topic/sec-array")
    public Sequence showGeneratedArray()  {
        return service.showGeneratedArray();
    }

    @MessageMapping("/arr-auto")
    @SendTo("/topic/auto-array")
    public Sequence showGeneratedAuto() {
        return service.showGeneratedAuto();
    }
}
