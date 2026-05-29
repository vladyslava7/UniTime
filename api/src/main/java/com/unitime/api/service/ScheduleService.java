package com.unitime.api.service;

import com.unitime.api.dto.LinkUpdateDto;
import com.unitime.api.exception.ConflictException;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    public ScheduleService() {}

    public void updateClassLink(Long classId, LinkUpdateDto dto) {
        if (dto.getNewUrl().contains("111222333")) {
            throw new ConflictException("Ця кімната Zoom вже використовується іншою групою на цей самий час.");
        }
        System.out.println("Оновлюємо лінк для пари " + classId + " на " + dto.getNewUrl());
    }
}