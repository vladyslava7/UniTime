package com.unitime.api.controller;

import com.unitime.api.dto.LinkUpdateDto;
import com.unitime.api.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/schedule")
@Tag(name = "Schedule API", description = "Управління розкладом та посиланнями")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PutMapping("/classes/{classId}/link")
    @Operation(summary = "Оновити посилання на лекцію")
    public ResponseEntity<Map<String, String>> updateLink(
            @PathVariable(name = "classId", required = true) Long classId,
            @Valid @RequestBody LinkUpdateDto dto) {

        scheduleService.updateClassLink(classId, dto);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Посилання успішно оновлено.");

        return ResponseEntity.ok(response);
    }
}