package com.example.springeventtest.domain.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class AppEventListenerTest {

    // 이벤트 리스너 인스턴스 생성
    private AppEventListener appEventListener;

    @BeforeEach
    public void init() {
        appEventListener = new AppEventListener();
    }

    @Test
    public void testOnApplicationEvent() {

        // given
        Long mailId = 1L;

        Long pushId = 2L;

        AppEvent mockEvent = mock(AppEvent.class);

        when(mockEvent.getMailId()).thenReturn(mailId);
        when(mockEvent.getPushId()).thenReturn(pushId);

        //when
        appEventListener.onApplicationEvent(mockEvent);

        //then
        verify(mockEvent, times(1)).getMailId();
        verify(mockEvent, times(1)).getPushId();
    }
}
