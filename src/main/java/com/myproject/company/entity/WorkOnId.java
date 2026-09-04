package com.myproject.company.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkOnId implements Serializable {

    @Column(name = "empno")
    private Integer idE;
    @Column(name = "projectno" )
    private Integer idP;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkOnId that = (WorkOnId) o;
        return Objects.equals(idE, that.idE) && Objects.equals(idP, that.idP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idE, idP);
    }
}
