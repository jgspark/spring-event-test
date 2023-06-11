package com.example.springeventtest.service.event;

import com.example.springeventtest.domain.event.AppEvent;
import com.example.springeventtest.domain.event.AppEvent2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AppEventServiceTest {

    private AppEventService appEventService;

    private final ApplicationEventPublisher publisher = mock(ApplicationEventPublisher.class);

    @BeforeEach
    void setUp() {
        appEventService = new AppEventService(publisher);
    }

    @Test
    @DisplayName("이벤트 검증 테스트 케이스")
    void testCall() {

        Long event1MailId = 1L;

        Long event1PushId = 2L;

        Long event2MailId = 3L;

        Long event2PushId = 4L;

        // 테스트할 메서드 호출
        appEventService.call();

        // publishEvent가 두 번 호출되었는지 확인
        // 이벤트 검증 로직이 2번 호출이 되었는가?
        // 이벤트 호출은 2번 호출이 되기 때문에 times 에 2 를 추가
        verify(publisher, times(2)).publishEvent(any());

        // event1 검증
        // publishEvent에 전달된 인자를 확인하려면 ArgumentCaptor를 사용할 수 있습니다.
        // 예를 들어, 첫 번째 publishEvent 호출에 대한 인자 확인:
        ArgumentCaptor<AppEvent> appEvent1Captor = ArgumentCaptor.forClass(AppEvent.class);

        verify(publisher).publishEvent(appEvent1Captor.capture());

        AppEvent event1 = appEvent1Captor.getValue();

        // event1 필드 값에 대한 검증 등을 수행합니다.
        assertEquals(event1MailId, event1.getMailId());
        assertEquals(event1PushId, event1.getPushId());

        // event2 검증
        ArgumentCaptor<AppEvent2> appEvent2Captor = ArgumentCaptor.forClass(AppEvent2.class);
        verify(publisher).publishEvent(appEvent2Captor.capture());

        AppEvent2 event2 = appEvent2Captor.getValue();

        assertEquals(event2MailId, event2.getMailId());
        assertEquals(event2PushId, event2.getPushId());
    }
}
