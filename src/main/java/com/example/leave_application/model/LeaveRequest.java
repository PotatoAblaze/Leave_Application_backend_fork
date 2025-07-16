package com.example.leave_application.model;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false)
    private User requestedBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private User flaApprover;

    @ManyToOne(fetch = FetchType.EAGER)
    private User slaApprover;

    @Column(nullable = false, length = 2000)
    private String reason;

    private LocalDate startDate;
    private LocalDate endDate;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<LeaveType> leaveTypes;

    private int leaveCount;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

    @Column(length = 100)
    private String substitute;

    private LocalDateTime flaApprovalAt;
    private LocalDateTime slaApprovalAt;
    private LocalDateTime hrApprovalAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime appliedAt;

    public void validate() {
        if(leaveTypes.isEmpty()) throw new ValidationException("Must select at least one leave type");
        if(leaveTypes.contains(LeaveType.CL) && leaveTypes.contains(LeaveType.PL)) throw new ValidationException("Cannot have both PL and CL leaves at once.");
        if(slaApprover == null && flaApprover == null) throw new ValidationException("Must have at least one approver.");
    }
}
