package com.example.leave_application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ApprovalDtos {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class FlaApprovalDto {
        @NotNull
        Long slaSelected;
        @NotBlank
        String substituteSelected;
        @NotNull
        Boolean isApproved;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class SlaApprovalDto {
        @NotNull
        Boolean isApproved;
        String substituteSelected;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class HrApprovalDto {
        @NotNull
        Boolean isApproved;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class FlaPassApprovalDto {
        @NotNull
        Long slaSelected;
        @NotNull
        Boolean isApproved;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class SlaPassApprovalDto {
        @NotNull
        Boolean isApproved;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class HrPassApprovalDto {
        @NotNull
        Boolean isApproved;
    }
}
