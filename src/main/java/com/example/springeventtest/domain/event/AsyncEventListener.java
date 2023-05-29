package com.example.springeventtest.domain.event;

import com.example.springeventtest.infra.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AsyncEventListener {

    private final HistoryRepository historyRepository;

    /**
     * 케이스 1 :  @TransactionalEventListener 의 경우 트랜잭션을 이어주는 리스너 인듯 ?
     * 부모의 트랜잭션이 없으면 리스너가 동작하지 않는다. 왜 ? -> 현재 디버그 중
     * <p>
     * 케이스 2 : 트랜잭션이 없으면 작동이 안되는데 @EventListener 만 사용안하고 만약 트랜잭션 고립 처럼 사용을 하면 처리를 해주는 것이 맞는 의미 인듯?
     */

    @Async
    @Transactional
    @EventListener(value = AppEvent2.class)
    public void sendEvent(AppEvent2 appEvent2) {

        Push push = new Push(appEvent2.getPushId());
        Mail mail = new Mail(appEvent2.getMailId());
        push.send();
        mail.send();

        Optional<History> mailHistoryOptional = historyRepository.findByMailId(mail.getMailId());

        if (mailHistoryOptional.isPresent()) {
            mailHistoryOptional.get().update();
        } else {
            History entity = History.of(mail.getMailId(), push.getPushId());
            historyRepository.save(entity);
        }
    }
}
