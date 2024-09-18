package com.emazon.supply.adapters.driving.http.controller;

import com.emazon.supply.adapters.driving.http.dto.request.SupplyRequest;
import com.emazon.supply.adapters.driving.http.mapper.request.ISupplyRequestMapper;
import com.emazon.supply.configuration.exceptionhandler.ExceptionResponse;
import com.emazon.supply.domain.api.ISupplyServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyController {

    private final ISupplyServicePort supplyService;
    private final ISupplyRequestMapper supplyRequestMapper;

    @Operation(summary = "Add supply to article", description = "This endpoint allows you to add supply to an article")
    @ApiResponse(responseCode = "200", description = "Supply added correctly.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Incorrect add supply request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))})
    @ApiResponse(responseCode = "500", description = "Sever not avalaible to supply article", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))})
    @PostMapping("/add")
    public ResponseEntity<String> addSupply(@Valid @RequestBody SupplyRequest supplyRequest){
        supplyService.saveSupply(supplyRequestMapper.toSupply(supplyRequest));
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Get the last delivery date of an article",
            description = "This endpoint retrieves the last delivery date of a specific article based on its ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Last delivery date retrieved successfully.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = LocalDate.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Article not found.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class)
            )
    )
    @GetMapping("/last-delivery-date/{idArticle}")
    public ResponseEntity<LocalDate> getLastDeliveryDate(@PathVariable("idArticle") Long idArticle){
        return ResponseEntity.ok(supplyService.getLastDateOfDeliveryOfArticle(idArticle));
    }

}
