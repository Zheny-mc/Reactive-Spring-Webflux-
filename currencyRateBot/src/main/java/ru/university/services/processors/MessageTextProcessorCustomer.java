package ru.university.services.processors;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.university.clients.currency_rate_client.CustomerClient;
import ru.university.model.MessageTextProcessorResult;


@Slf4j
@AllArgsConstructor
@Service("messageTextProcessorCustomer")
public class MessageTextProcessorCustomer implements MessageTextProcessor {
//    private static final String CBR_RATE_CONST = "CBR";
//    private static final String DATE_FORMAT_ZERO = "dd-MM-yyyy";
//    private static final String DATE_FORMAT = "d-MM-yyyy";
//    private static final DateTimeFormatter DATE_FORMATTER_ZERO = DateTimeFormatter.ofPattern(DATE_FORMAT_ZERO);
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
//    private final DateTimeProvider dateTimeProvider;
    private final CustomerClient customerClient;

    @Override
    public Mono<MessageTextProcessorResult> process(String msgText) {
        log.info("msgText:{}", msgText);

        var textParts = msgText.split(" ");

        if (textParts.length != 1) {
            return Mono.just(new MessageTextProcessorResult(null, Messages.EXPECTED_FORMAT_MESSAGE.getText()));
        }

        Integer number = null;

        if (textParts.length == 1) {
            try {
                number = Integer.parseInt(textParts[0]);
            } catch (Exception ex) {
                System.out.println("ex = " + ex);
            }
        }

        return customerClient.getCustomer(number)
                .map(rate -> new MessageTextProcessorResult(rate.getName(), null));
    }

//    private LocalDate parseDate(String dateAsString) {
//        try {
//            return LocalDate.parse(dateAsString, DATE_FORMATTER_ZERO);
//        } catch (Exception ex) {
//            return LocalDate.parse(dateAsString, DATE_FORMATTER);
//        }
//    }
}
