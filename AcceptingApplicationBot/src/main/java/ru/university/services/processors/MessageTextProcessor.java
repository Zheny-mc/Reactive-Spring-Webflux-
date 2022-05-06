package ru.university.services.processors;

import reactor.core.publisher.Mono;
import ru.university.model.MessageTextProcessorResult;

public interface MessageTextProcessor {
    Mono<MessageTextProcessorResult> process(String msgText);
}
