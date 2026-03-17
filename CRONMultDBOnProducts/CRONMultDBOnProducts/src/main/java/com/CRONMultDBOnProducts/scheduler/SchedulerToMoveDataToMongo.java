package com.CRONMultDBOnProducts.scheduler;

import com.CRONMultDBOnProducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class SchedulerToMoveDataToMongo {

    private final ProductService productService;

    @Scheduled(cron = "${cron.job.expression}")
    public void moveDataToMongo() {
        productService.moveDataToMongo();
    }
}
