package ru.university.services.processors;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.university.model.MessageTextProcessorResult;

import static ru.university.services.processors.Messages.EXPECTED_FORMAT_MESSAGE;

@Service("messageTextProcessorStart")
public class MessageTextProcessorStart implements MessageTextProcessor {
    @Override
    public Mono<MessageTextProcessorResult> process(String msgText) {
        return Mono.just(new MessageTextProcessorResult(EXPECTED_FORMAT_MESSAGE.getText(), null));
    }
}
