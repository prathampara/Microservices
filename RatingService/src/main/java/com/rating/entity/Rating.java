package com.rating.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rating")
public class Rating {
    @Id
    @Column(name = "id", nullable = false)
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;

}