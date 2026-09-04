package com.myproject.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(WorkOnId.class)
public class WorkOn {
    @Id
    @Column(name = "empno")
    private Integer idE;
    @Id
    @Column(name = "projectno")
    private Integer idP;
}
