package ecommerce.filasqs.service;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageReceiver {

    @SqsListener(value = "testeDiego", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(String message,
                               @Header("SenderId") String senderId) {
        log.info("message received {} {}",senderId,message);
    }

}
