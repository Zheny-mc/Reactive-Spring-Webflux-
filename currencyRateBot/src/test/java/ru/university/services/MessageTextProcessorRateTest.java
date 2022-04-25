package ru.university.services;

import static org.mockito.Mockito.mock;

class MessageTextProcessorRateTest {
//
//    @Test
//    void processTestAgrs3() {
//        //given
//        var currencyRateClient = mock(CustomerClient.class);
//        var currencyRate = new Customer("USD", "1", "49.4");
//        var resultExpected = new MessageTextProcessorResult(currencyRate.getValue(), null);
//        when(currencyRateClient.getCustomer("CBR", "USD", LocalDate.of(2021, 2, 3)))
//                .thenReturn(Mono.just(currencyRate));
//
//        var messageTextProcessor = new MessageTextProcessorCustomer(currencyRateClient,
//                () -> LocalDateTime.of(2021, 2, 3,1,1,1));
//        var msg = "CBR USD 3-02-2021";
//
//        //when
//        var result = messageTextProcessor.process(msg);
//
//        //then
//        StepVerifier
//                .create(result)
//                .expectNext(resultExpected)
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    void processTestAgrs2() {
//        //given
//        var currencyRateClient = mock(CustomerClient.class);
//        var currencyRate = new Customer("USD", "1", "49.4");
//        var resultExpected = new MessageTextProcessorResult(currencyRate.getValue(), null);
//        when(currencyRateClient.getCustomer("CBR", "USD", LocalDate.of(2021, 2, 3)))
//                .thenReturn(Mono.just(currencyRate));
//
//        var messageTextProcessor = new MessageTextProcessorCustomer(currencyRateClient,
//                () -> LocalDateTime.of(2021, 2, 3,1,1,1));
//        var msg = "USD 03-02-2021";
//
//        //when
//        var result = messageTextProcessor.process(msg);
//
//        //then
//        StepVerifier
//                .create(result)
//                .expectNext(resultExpected)
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    void processTestAgrs1() {
//        //given
//        var currencyRateClient = mock(CustomerClient.class);
//        var currencyRate = new Customer("USD", "1", "49.4");
//        var resultExpected = new MessageTextProcessorResult(currencyRate.getValue(), null);
//        when(currencyRateClient.getCustomer("CBR", "USD", LocalDate.of(2021, 2, 3)))
//                .thenReturn(Mono.just(currencyRate));
//
//        var messageTextProcessor = new MessageTextProcessorCustomer(currencyRateClient,
//                () -> LocalDateTime.of(2021, 2, 3,1,1,1));
//        var msg = "USD";
//
//        //when
//        var result = messageTextProcessor.process(msg);
//
//        //then
//        StepVerifier
//                .create(result)
//                .expectNext(resultExpected)
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    void processTestAgrsWrongData() {
//        //given
//        var currencyRateClient = mock(CustomerClient.class);
//        var currencyRate = new Customer("USD", "1", "49.4");
//        var resultExpected = new MessageTextProcessorResult(null, Messages.NUMBER_FORMAT_MESSAGE.getText());
//        when(currencyRateClient.getCustomer("CBR", "USD", LocalDate.of(2021, 2, 3)))
//                .thenReturn(Mono.just(currencyRate));
//
//        var messageTextProcessor = new MessageTextProcessorCustomer(currencyRateClient,
//                () -> LocalDateTime.of(2021, 2, 3,1,1,1));
//        var msg = "USD 2021.03.01";
//
//        //when
//        var result = messageTextProcessor.process(msg);
//
//        //then
//        StepVerifier
//                .create(result)
//                .expectNext(resultExpected)
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    void processTestAgrsWrongFormat() {
//        //given
//        var currencyRateClient = mock(CustomerClient.class);
//        var currencyRate = new Customer("USD", "1", "49.4");
//        var resultExpected = new MessageTextProcessorResult(null, Messages.EXPECTED_FORMAT_MESSAGE.getText());
//        when(currencyRateClient.getCustomer("CBR", "USD", LocalDate.of(2021, 2, 3)))
//                .thenReturn(Mono.just(currencyRate));
//
//        var messageTextProcessor = new MessageTextProcessorCustomer(currencyRateClient,
//                () -> LocalDateTime.of(2021, 2, 3,1,1,1));
//        var msg = "RRR RRR USD 03-02-2021";
//
//        //when
//        var result = messageTextProcessor.process(msg);
//
//        //then
//        StepVerifier
//                .create(result)
//                .expectNext(resultExpected)
//                .expectComplete()
//                .verify();
//    }
}